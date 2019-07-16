#include <queue>
#include <tuple>
#include <iostream>
#include <mutex>
#include <condition_variable>
#include <thread>
#include <unistd.h>

template <class T>
class Channels
{
  std::queue<T> data;
  std::mutex mtx;
  std::mutex mtx_write;
  std::condition_variable cv;
  std::condition_variable cv_write;
  int limit = 0;  

public:
  Channels(int num) : limit(num) {}

  bool push(T x)
  {
    if (0 == limit)
    {
      return false;
    }

    {
      if (data.size() >= limit)
      {
        std::unique_lock<std::mutex> lck1(mtx_write);
        cv_write.wait(lck1, [&] { return this->data.size() < limit || limit == 0; });
      }

      std::unique_lock<std::mutex> lck(mtx);
      data.push(x);
    }
    cv.notify_one();

    return true;
  }

  std::tuple<T, bool> get()
  {
    T d;

    if (0 == limit)
    {
        return std::make_tuple(d, false);
    }

    {
        std::unique_lock<std::mutex> lck(mtx);
        if (data.empty())
        {
            cv.wait(lck, [&] { return this->data.size() > 0; });
        }

        d = data.front();
        data.pop();

        std::unique_lock<std::mutex> lck1(mtx_write);
        cv_write.notify_one();
    }
    //sleep(1);
    cv.notify_one();

    return std::make_tuple(d, true);
  }

  bool close()
  {
    limit = 0;

    std::unique_lock<std::mutex> lck1(mtx_write);
    cv_write.notify_all();
  }

  bool is_close()
  {
    return limit == 0;
  }
};
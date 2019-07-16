#include "channels.hpp"

using namespace std;

void producer(Channels<int> &p) {

    for(int i=0; i< 10; i++) {
        p.push(i);
        cout << "Pushed: " << i << endl;
    }
}

void consumer(Channels<int> &p) {

    for(int i=0; i< 10; i++) {
        auto [a,b] = p.get();
        cout << "Getting: " << a << endl;
    }
}

int main()
{
    Channels<int> x(1);

    std::thread t1(producer,std::ref(x));
    std::thread t2(consumer,std::ref(x));
    
    t1.join();
    t2.join();
    x.close();
    return 0;
}

#include "logger.h"
#include <iostream>
#include <thread>


void log_test(int n)
{
    Logger::Info("%d", n);
}

void example2()
{
    std::thread threads[10];

    for(int i = 0; i < 10; i++)
    {
        threads[i] = std::thread(log_test, i);
    }

    for(int i = 0; i < 10; i++)
    {
        threads[i].join();
    }


}


int main() {

    example2();


    return 0;
}
#include "logger.h"
#include <thread>

void example1() 
{
    int a = 5;
    const char* name = "John";

    Logger::set_priority(TracePriority);

    Logger::Trace("Log test %d %s", a, name);
    Logger::Debug("Log test %d %s", a, name);
    Logger::Info("Log test %d %s", a, name);
    Logger::Warn("Log test %d %s", a, name);
    Logger::Critical("Log test %d %s", a, name);
    Logger::Error("Log test %d %s", a, name);
}

void log_test(int n) 
{
    Logger::Info("%d", n);
}


void example2() 
{
    std::thread threads[10];

    for(int i = 0; i < 10; i++) {
        threads[i] = std::thread(log_test, i);
    }

}

int main () 
{
    example1();
    example2();
 
    return 0;
}
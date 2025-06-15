#pragma once

#include <stdio.h>

enum LogPriority 
{
    TracePriority, DebugPriority, InfoPriority, WarnPriority, ErrorPriority, CriticalPriority
};

class Logger
{
    
private:
    static LogPriority priority;

public:
    static void set_priority(LogPriority new_priority)
    {
        priority = new_priority;
    }

    template<typename... Args>
    static void Trace(const char* message, Args... args) 
    {
        if(priority <= TracePriority)
        {
            printf("[Trace]\t");
            printf(message, args);
            print("\n");
        }
    }

    template<typename... Args>
    static void Debug(const char* message, Args... args) 
    {
        if(priority <= DebugPriority)
        {
            printf("[DEBUG]\t");
            printf(message, args);
            print("\n");
        }
    }

    template<typename... Args>
    static void Info(const char* message, Args... args) 
    {
        if(priority <= InfoPriority)
        {
            printf("[Info]\t");
            printf(message, args);
            print("\n");
        }
    }

    template<typename... Args>
    static void Error(const char* message, Args... args) 
    {
        if(priority <= TracePriority)
        {
            printf("[Error]\t");
            printf(message, args);
            print("\n");
        }
    }

    template<typename... Args>
    static void Warn(const char* message, Args... args) 
    {
        if(priority <= WarnPriority)
        {
            printf("[Warn]\t");
            printf(message, args);
            print("\n");
        }
    }

    template<typename... Args>
    static void Critical(const char* message, Args... args) 
    {
        if(priority <= CriticalPriority)
        {
            printf("[Critical]\t");
            printf(message, args);
            print("\n");
        }
    }

};

LogPriority Logger::priority = InfoPriority;
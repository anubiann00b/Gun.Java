package io.gundb;

class Logger {
    
    static void log(String str) {
        System.out.println(str);
    }
    
    static void log(Throwable t) {
        log(t.toString());
    }
}

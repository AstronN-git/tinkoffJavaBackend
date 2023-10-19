package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace.length <= 1) {
                throw new RuntimeException("Nobody called this method");
            }

            return new CallingInfo(stackTrace[1].getClassName(), stackTrace[1].getMethodName());
        }
    }
}

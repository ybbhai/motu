package fr.cls.atoll.motu.library.misc.queueserver;

import java.util.concurrent.ConcurrentMap;

/**
 * Interface that exposes the properties and methods that are visible from JMX.
 */
public interface ExtractionThreadPoolExecutorMBean {
    ConcurrentMap<String, Integer> getUsersRequestNumberMap();

    ConcurrentMap<Integer, Integer> getPriorityMap();

    String getId();

    int getActiveCount();

    long getCompletedTaskCount();

    int getCorePoolSize();

    int getLargestPoolSize();

    int getMaximumPoolSize();

    int getPoolSize();

    long getTaskCount();

    boolean isShutdown();

    boolean isTerminated();

    boolean isTerminating();

    int usersSize();

    int countNumberRequests();

}

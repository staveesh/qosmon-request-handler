package com.taveeshsharma.requesthandler.orchestration;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class JobDispatcher {
    private final Set<DispatchTask> tasks = new TreeSet<>((t1, t2) -> {
        if(t1.getDispatchTime().isBefore(t2.getDispatchTime()))
            return -1;
        else if (t1.getDispatchTime().equals(t2.getDispatchTime()))
            return (t1.getJob().getKey()).compareTo((t2.getJob().getKey()));
        else
            return 1;
    });
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private AtomicInteger lastDispatched = new AtomicInteger(0);

    public void addNewTask(DispatchTask task) {
        acquireWriteLock();
        tasks.add(task);
        releaseWriteLock();
    }

    public void acquireReadLock() {
        readWriteLock.readLock().lock();
    }

    public void releaseReadLock() {
        readWriteLock.readLock().unlock();
    }

    public void acquireWriteLock() {
        readWriteLock.writeLock().lock();
    }

    public void releaseWriteLock() {
        readWriteLock.writeLock().unlock();
    }

    public Set<DispatchTask> getTasks() {
        return tasks;
    }

    public int getLastDispatched() {
        return lastDispatched.get();
    }

    public void setLastDispatched(AtomicInteger lastDispatched) {
        this.lastDispatched = lastDispatched;
    }
}

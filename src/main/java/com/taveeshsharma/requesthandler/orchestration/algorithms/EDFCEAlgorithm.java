package com.taveeshsharma.requesthandler.orchestration.algorithms;

import com.taveeshsharma.requesthandler.dto.documents.Job;
import com.taveeshsharma.requesthandler.orchestration.ConflictGraph;
import com.taveeshsharma.requesthandler.orchestration.Assignment;
import com.taveeshsharma.requesthandler.utils.ApiUtils;
import com.taveeshsharma.requesthandler.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("edfCeAlgorithm")
public class EDFCEAlgorithm extends SchedulingAlgorithm{

    private static final Logger logger = LoggerFactory.getLogger(EDFCEAlgorithm.class);

    /**
     * Performs scheduling in such a way that jobs with earliest deadlines get scheduled first.
     *
     * @param graph
     * @return
     */
    @Override
    public List<Job> preprocessJobs(ConflictGraph graph, List<String> devices) {
        logger.info("Preprocessing jobs using EDF-CE scheme");
        List<Job> jobs = graph.getJobs();
        jobs.sort((j1, j2) -> {
            if (j1.getNextReset().before(j2.getNextReset()))
                return -1;
            else if (j1.getNextReset().equals(j2.getNextReset()))
                return 0;
            else
                return 1;
        });
        return jobs;
    }
}
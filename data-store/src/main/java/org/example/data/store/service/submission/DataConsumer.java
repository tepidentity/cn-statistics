package org.example.data.store.service.submission;

import org.example.data.store.dto.submission.SubmissionDto;

public interface DataConsumer {

    void consume(SubmissionDto country);
}

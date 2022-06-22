package org.example.data.source.service.submission;

import org.example.data.source.dto.submission.SubmissionDto;

public interface DataConsumer {

    void consume(SubmissionDto country);
}

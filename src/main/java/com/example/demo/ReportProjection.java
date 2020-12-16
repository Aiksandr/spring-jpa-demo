package com.example.demo;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

public interface ReportProjection {
    String getId();
    LocalDateTime getCreateDate();
}

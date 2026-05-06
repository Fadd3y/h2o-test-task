package ru.project.h2otesttask.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
  private final int status;
  private final String message;
  private final LocalDateTime timestamp = LocalDateTime.now();

  public ErrorResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}

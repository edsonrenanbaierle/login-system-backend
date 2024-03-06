package infra.exeptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
  private int statusCode;
  private String message;

  public ErrorResponse(int statusCode, String message) {
      this.statusCode = statusCode;
      this.message = message;
  }
}

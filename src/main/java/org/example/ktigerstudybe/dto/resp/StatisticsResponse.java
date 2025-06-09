package org.example.ktigerstudybe.dto.resp;

import lombok.Data;

@Data
public class StatisticsResponse {
    private long totalUsers;
    private long frozenUsers;
    private long newUsers;
}

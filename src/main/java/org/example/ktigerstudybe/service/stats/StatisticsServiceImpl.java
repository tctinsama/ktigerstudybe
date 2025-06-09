package org.example.ktigerstudybe.service.stats;

import org.example.ktigerstudybe.dto.resp.StatisticsResponse;
import org.example.ktigerstudybe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public StatisticsResponse getStatistics() {
        StatisticsResponse resp = new StatisticsResponse();
        resp.setTotalUsers(userRepository.count());
        resp.setFrozenUsers(userRepository.countByUserStatus(1));
        resp.setNewUsers(userRepository.countByJoinDateAfter(LocalDate.now().minusDays(7)));
        return resp;
    }
}

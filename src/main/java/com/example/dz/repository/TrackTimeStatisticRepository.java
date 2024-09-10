package com.example.dz.repository;

import com.example.dz.model.TrackTimeMaxStatistic;
import com.example.dz.model.TrackTimeMinStatistic;
import com.example.dz.model.TrackTimeModel;
import com.example.dz.model.TrackTimeAvgStatistic;
import com.example.dz.model.TrackTimeSumStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrackTimeStatisticRepository extends JpaRepository<TrackTimeModel, Integer> {

    @Query(value = "select new com.example.dz.model.TrackTimeMaxStatistic(t.isAsync, t.methodPath, t.methodName,  max(t.timeWork)) from TrackTimeModel t group by t.isAsync, t.methodPath, t.methodName")
    List<TrackTimeMaxStatistic> findMaxTrackTimeForAllMethods();

    @Query(value = "select new com.example.dz.model.TrackTimeMinStatistic(t.isAsync, t.methodPath, t.methodName,  min(t.timeWork)) from TrackTimeModel t group by t.isAsync, t.methodPath, t.methodName")
    List<TrackTimeMinStatistic> findMinTrackTimeForAllMethods();

    @Query(value = "select new com.example.dz.model.TrackTimeSumStatistic(t.isAsync, t.methodPath, t.methodName,  sum(t.timeWork)) from TrackTimeModel t group by t.isAsync, t.methodPath, t.methodName")
    List<TrackTimeSumStatistic> findSumTrackTimeForAllMethods();

    @Query(value = "select new com.example.dz.model.TrackTimeAvgStatistic(t.isAsync, t.methodPath, t.methodName,  avg(t.timeWork)) from TrackTimeModel t group by t.isAsync, t.methodPath, t.methodName")
    List<TrackTimeAvgStatistic> findAvgTrackTimeForAllMethods();
}

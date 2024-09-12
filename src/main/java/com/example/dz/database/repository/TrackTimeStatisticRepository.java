package com.example.dz.database.repository;

import com.example.dz.model.MaxStatisticResponse;
import com.example.dz.model.MinStatisticResponse;
import com.example.dz.database.entity.TrackTimeStatistic;
import com.example.dz.model.AvgStatisticResponse;
import com.example.dz.model.SumStatisticResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrackTimeStatisticRepository extends JpaRepository<TrackTimeStatistic, Integer> {

    @Query(value = "select new com.example.dz.model.MaxStatisticResponse(t.isAsync, t.methodName,  max(t.timeWork)) from TrackTimeStatistic t group by t.isAsync, t.methodName")
    List<MaxStatisticResponse> findMaxTrackTimeForAllMethods();

    @Query(value = "select new com.example.dz.model.MinStatisticResponse(t.isAsync, t.methodName,  min(t.timeWork)) from TrackTimeStatistic t group by t.isAsync, t.methodName")
    List<MinStatisticResponse> findMinTrackTimeForAllMethods();

    @Query(value = "select new com.example.dz.model.SumStatisticResponse(t.isAsync, t.methodName,  sum(t.timeWork)) from TrackTimeStatistic t group by t.isAsync, t.methodName")
    List<SumStatisticResponse> findSumTrackTimeForAllMethods();

    @Query(value = "select new com.example.dz.model.AvgStatisticResponse(t.isAsync, t.methodName,  avg(t.timeWork)) from TrackTimeStatistic t group by t.isAsync, t.methodName")
    List<AvgStatisticResponse> findAvgTrackTimeForAllMethods();
}

package com.octo.repository;


import com.octo.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VideoRepository extends JpaRepository<Video, String>, JpaSpecificationExecutor<Video> {
}

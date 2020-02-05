package com.octo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

@Service
public class VideoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

	@Autowired
	private VideoRepository videoRepository;
	@Autowired
	private VideoToVideoDTOMapper videoToVideoDTOMapper;

	public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {
		LOGGER.debug("retrieving videos By Tags And Level");
		List<Video> videos = this.videoRepository.findAll();
		try {
			if (tags != null && !tags.isEmpty())
				videos = videos.stream().filter(v -> v.getTags().containsAll(tags)).collect(Collectors.toList());

			if (level != null)
				videos = videos.stream().filter(v -> v.getLevel().equals(level)).collect(Collectors.toList());

			return videos.stream().map(video -> this.videoToVideoDTOMapper.convert(video)).collect(Collectors.toList());

		} catch (Exception ex) {
			LOGGER.error("Exception while retrieving videos by tags and level : ", ex);
			return null;
		}

	}

}

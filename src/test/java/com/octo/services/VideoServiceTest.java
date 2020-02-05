package com.octo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest {

	@InjectMocks
	private VideoService videoService;
	@Mock
	private VideoRepository videoRepository;
	@Mock
	private VideoToVideoDTOMapper videoToVideoDTOMapper;


	@org.junit.Before
	public void init() {
	}

	@Test
	public void retrieveVideoByTagsAndOrLevel_test() {
		List<Video> videos = new ArrayList<Video>();

		List<String> tags = new ArrayList<String>();

		tags.add("POURCENTAGE");
		Video v = new Video();
		v.setTitle("Présentation");
		v.setDuration(19.29);
		v.setTags(tags);
		v.setLevel(Level.MEDIUM);
		videos.add(v);

		when(videoRepository.findAll()).thenReturn(videos);
		List<VideoDTO> videoDTOs = this.videoService.retrieveVideosByTagAndLevel(tags, Level.MEDIUM);
		assertEquals(1, videoDTOs.size());
	}
	
	@Test(expected = Exception.class)
	public void retrieveVideoByTagsAndOrLevel_exception() {
		when(videoRepository.findAll()).thenThrow(Exception.class);
		verify(this.videoRepository.findAll());
	}
	
	

}
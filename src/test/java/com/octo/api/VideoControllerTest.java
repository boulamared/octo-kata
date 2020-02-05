package com.octo.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.octo.domain.enums.Level;
import com.octo.dto.video.VideoDTO;
import com.octo.holders.ApiPaths;
import com.octo.services.VideoService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class VideoControllerTest {


    @InjectMocks
    VideoController videoController;
    @Mock
    VideoService videoService;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(videoController).build();
    }

    @Test
    public void getQuestionGroup_noTags_noLevel() throws Exception {
        List<VideoDTO> list = new ArrayList<>();
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId("12345678");
        videoDTO.setLevel(Level.EASY);
        list.add(videoDTO);

        when(videoService.retrieveVideosByTagAndLevel(null, null)).thenReturn(list);

        mockMvc.perform(get(ApiPaths.V1 + ApiPaths.VIDEOS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

}
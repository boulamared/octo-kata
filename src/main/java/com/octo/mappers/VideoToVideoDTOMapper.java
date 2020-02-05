package com.octo.mappers;

import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class VideoToVideoDTOMapper implements Converter<Video, VideoDTO> {

    @Override
    public VideoDTO convert(Video video) {

        if (video != null) {
            final VideoDTO videoDTO = new VideoDTO();
            videoDTO.setId(video.getId());
            videoDTO.setTitle(video.getTitle());
            videoDTO.setDescription(video.getDescription());
            videoDTO.setTags(video.getTags());
            videoDTO.setLevel(video.getLevel());
            videoDTO.setDuration(video.getDuration());
            videoDTO.setUrl(video.getUrl());
            return videoDTO;
        }
        return null;
    }
}

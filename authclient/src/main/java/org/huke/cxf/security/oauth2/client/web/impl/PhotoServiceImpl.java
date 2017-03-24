package org.huke.cxf.security.oauth2.client.web.impl;

import org.huke.cxf.security.oauth2.client.web.PhotoService;
import org.huke.cxf.security.oauth2.client.web.domain.Photo;
import org.springframework.stereotype.Service;

/**
 * @author huke
 * @create 2017/3/18
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Override
    public Photo getPhoto(int photoId) {
        //TODO : 像 resource server 请求资源.
        Photo photo = new Photo();
        photo.setId(1232);
        photo.setUrl("http://local.resource.photo.1231.jpg");
        return photo;
    }
}

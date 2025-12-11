package com.grupodos.alquilervehiculos.msvc_vehiculos.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(File file) throws IOException {

        Map uploadResult = cloudinary.uploader().upload(
                file,
                ObjectUtils.asMap("folder", "soluciones-integrales-juri/vehiculos"));
        return uploadResult.get("secure_url").toString();
    }
}

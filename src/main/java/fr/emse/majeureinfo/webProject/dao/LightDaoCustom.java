package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Light;

import java.util.List;

public interface LightDaoCustom {
    List<Light> findOnLights();
}

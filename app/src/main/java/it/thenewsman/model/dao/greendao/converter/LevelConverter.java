package it.thenewsman.model.dao.greendao.converter;

import org.greenrobot.greendao.converter.PropertyConverter;

import it.thenewsman.model.Level;

public class LevelConverter implements PropertyConverter<Level, Integer> {
        @Override
        public Level convertToEntityProperty(Integer databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            for (Level level : Level.values()) {
                if (level.getLevel() == databaseValue) {
                    return level;
                }
            }
            return Level.UNKNOWN;
        }
 
        @Override
        public Integer convertToDatabaseValue(Level entityProperty) {
            return entityProperty == null ? null : entityProperty.getLevel();
        }
    }
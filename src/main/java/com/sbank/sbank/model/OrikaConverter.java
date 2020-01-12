package com.sbank.sbank.model;

import com.sbank.sbank.model.web.WebUser;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConverter   {
    private MapperFacade mapperFacade;

    public OrikaConverter() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(User.class, WebUser.class)
                .byDefault().register();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    public User map(WebUser webUser) {
        return mapperFacade.map(webUser, User.class);
    }

    public WebUser map(User user) {
        return mapperFacade.map(user, WebUser.class);
    }
}

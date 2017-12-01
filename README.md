# Hibernate Cache

## The first-level cache 一级缓存
一级缓存也是session缓存，生命周期为session生命周期，仅缓存映射实体对象。默认开启

## The second-level cache 二级缓存

二级缓存,各个session之间共享。自定义失效时间。

- Class Cache Region 类级别的二级缓存

    将类的实例存入缓存中，存放查询实体值

    `hibernate.common` 二级缓存 自定义区域命名

    缓存类 add
    ``` java
    @org.hibernate.annotations.Cache(region = "common", usage = CacheConcurrencyStrategy.READ_WRITE)
    ```
- Collection Cache Region

    存放的查询条件（即OID），真实的实体在类级别的二级缓存中
- Query Cache Region

    存放的查询条件（即OID），真实的实体在类级别的二级缓存中

    `hibernate.org.hibernate.cache.internal.StandardQueryCache`

    ``` java
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    User findByName(String name);
    ```

- Update Timestamps

    当程序执行新增、修改、删除的时候，会在时间戳缓存区域生成时间戳t,查询时根据时间戳t来判断上次缓存之后是否有数据更新，有则查库，更新缓存数据。（注：直接通过id主键查询，不会继续查库，能获取更新数据，说明在更新操作时会更新类级别缓存数据）

    `hibernate.org.hibernate.cache.spi.UpdateTimestampsCache`

## 二级缓存实现

### ehcahe

### redis

> 参考 `https://github.com/blueskycheryl/hibernate-redis` ,注意包版本问题：2.4.0 from `http://jcenter.bintray.com/com/github/debop/hibernate-redis`

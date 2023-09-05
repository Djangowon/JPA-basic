package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'") // 데이터베이스의 컬럼명
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) // DB에는 Enum타입이 없는데, 엔티티 매핑에서 Enum타입을 사용할 때 사용함
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // Java의 Date타입 안에는 날짜, 시간 다 있지만, DB에는 DATE, TIME, TIMESTAMP를 구분해서 쓰기 때문에 매핑 정보를 주어야 함
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
    @Lob // Varchar를 넘어서는 큰 컨텐츠를 넣고 싶을 때 사용함
    private String description;

    public Member() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

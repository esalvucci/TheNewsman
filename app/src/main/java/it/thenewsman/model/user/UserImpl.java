package it.thenewsman.model.user;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import it.thenewsman.model.Level;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.dao.greendao.converter.LevelConverter;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import it.thenewsman.model.challenge.ChallengeDao;

/**
 * Concrete implementation of User concept.
 */
@Entity
public class UserImpl implements User{

    @Id(autoincrement = true)
    private long id;
    @NonNull
    private String name;
    private String avatar;
    private int points = 0;
    private Date birthday;
    private boolean acknowledgment = false;
    @NotNull
    @Convert(converter = LevelConverter.class, columnType = Integer.class)
    private Level level;
    @ToMany(referencedJoinProperty = "id")
    private List<Challenge> challenges = new LinkedList<>();
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 221744990)
    private transient UserImplDao myDao;

    /**
     *
     * @param name of the user.
     * @param avatar, image representing the user during the experience.
     * @param points gained by the user.
     * @param birthday of the user, it be useful to calculate his age and measure news' difficulty
     *                 according to it.
     */
    public UserImpl(String name, String avatar, int points, Date birthday) {
        this.name = name;
        this.avatar = avatar;
        this.points = points;
        this.birthday = birthday;
    }

    @Generated(hash = 1756456244)
    public UserImpl(long id, @NonNull String name, String avatar, int points, Date birthday,
            boolean acknowledgment, @NonNull Level level) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.points = points;
        this.birthday = birthday;
        this.acknowledgment = acknowledgment;
        this.level = level;
    }

    @Generated(hash = 751158277)
    public UserImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPoints(int points) {
        this.points = this.points + points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAcknowledgment(boolean acknowledgment) {
        this.acknowledgment = acknowledgment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addChallenge(Challenge challenge) {
        this.challenges.add(challenge);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAvatar() {
        return this.avatar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAge() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel() {
        return this.level;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAcknowledgment() {
        return this.acknowledgment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImpl user = (UserImpl) o;

        if (!name.equals(user.name)) return false;
        return avatar != null ? avatar.equals(user.avatar) : user.avatar == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                ", name='" + name + '\'' +
                ", avatar=" + avatar +
                ", points=" + points +
                ", challenges=" + challenges +
                ", acknowledgment=" + acknowledgment +
                '}';
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean getAcknowledgment() {
        return this.acknowledgment;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1926681287)
    public List<Challenge> getChallenges() {
        if (challenges == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChallengeDao targetDao = daoSession.getChallengeDao();
            List<Challenge> challengesNew = targetDao._queryUserImpl_Challenges(id);
            synchronized (this) {
                if (challenges == null) {
                    challenges = challengesNew;
                }
            }
        }
        return challenges;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 892801457)
    public synchronized void resetChallenges() {
        challenges = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 979502837)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserImplDao() : null;
    }
}

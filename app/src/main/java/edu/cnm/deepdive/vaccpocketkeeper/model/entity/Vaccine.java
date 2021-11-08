package edu.cnm.deepdive.vaccpocketkeeper.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity(
    tableName = "vaccine",
    indices = {
        @Index(value = {"name"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Vaccine {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "vaccine_id") //type affinity, if the type doesn't match one of the types in SQLite, can use type affitinity; pimarykey is automatically indeed and automatically unique
  private long id;

  @NonNull
  @ColumnInfo(index = true)
  private Date created = new Date();

  @NonNull
  @ColumnInfo
  private String name = "";

  @NonNull
  private String description = "";

  @ColumnInfo(name = "user_id", index = true) //type affinity, if the type doesn't match one of the types in SQLite, can use type affinity; pimarykey is automatically indexed and automatically unique
  private long userId;

  private int frequency;

  @ColumnInfo(name = "total_number_of_doses")
  private int totalNumberOfDoses;

  @ColumnInfo(name = "age_range_lower_limit")
  private int ageRangeLowerLimit;

  @ColumnInfo(name = "age_range_upper_limit")
  private int ageRangeUpperLimit;

  @Ignore
  private final List<Dose> doses = new LinkedList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getDescription() {
    return description;
  }

  public void setDescription(@NonNull String description) {
    this.description = description;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public int getFrequency() {
    return frequency;
  }

  public void setFrequency(int frequency) {
    this.frequency = frequency;
  }

  public int getTotalNumberOfDoses() {
    return totalNumberOfDoses;
  }

  public void setTotalNumberOfDoses(int totalNumberOfDoses) {
    this.totalNumberOfDoses = totalNumberOfDoses;
  }

  public int getAgeRangeLowerLimit() {
    return ageRangeLowerLimit;
  }

  public void setAgeRangeLowerLimit(int ageRangeLowerLimit) {
    this.ageRangeLowerLimit = ageRangeLowerLimit;
  }

  public int getAgeRangeUpperLimit() {
    return ageRangeUpperLimit;
  }

  public void setAgeRangeUpperLimit(int ageRangeUpperLimit) {
    this.ageRangeUpperLimit = ageRangeUpperLimit;
  }

  public List<Dose> getDoses() {
    return doses;
  }
}

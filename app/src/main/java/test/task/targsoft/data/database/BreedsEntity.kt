package test.task.targsoft.data.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import test.task.targsoft.model.Weight


@Entity(tableName = "breed")
data class BreedsEntity (

    @PrimaryKey
    val id: String,
    val adaptability: Int,
    @ColumnInfo(name = "affection_level")
    val affectionLevel: Int,
    @ColumnInfo(name = "alt_names")
    val altNames: String,
    @ColumnInfo(name = "cfa_url")
    val cfaUrl: String,
    @ColumnInfo(name = "child_friendly")
    val childFriendly: Int,
    @ColumnInfo(name = "country_code")
    val countryCode: String,
    @ColumnInfo(name = "country_codes")
    val countryCodes: String,
    val description: String,
    @ColumnInfo(name = "dog_friendly")
    val dogFriendly: Int,
    @ColumnInfo(name = "energy_level")
    val energyLevel: Int,
    val experimental: Int,
    val grooming: Int,
    val hairless: Int,
    @ColumnInfo(name = "health_issues")
    val healthIssues: Int,
    val hypoallergenic: Int,
    val indoor: Int,
    val intelligence: Int,
    val lap: Int,
    @ColumnInfo(name = "life_span")
    val lifeSpan: String,
    val name: String,
    val natural: Int,
    val origin: String,
    val rare: Int,
    val rex: Int,
    @ColumnInfo(name = "shedding_level")
    val sheddingLevel: Int,
    @ColumnInfo(name = "short_legs")
    val shortLegs: Int,
    @ColumnInfo(name = "social_needs")
    val socialNeeds: Int,
    @ColumnInfo(name = "stranger_friendly")
    val strangerFriendly: Int,
    @ColumnInfo(name = "suppressed_tail")
    val suppressedTail: Int,
    val temperament: String,
    @ColumnInfo(name = "vcahospitals_url")
    val vcahospitalsUrl: String,
    @ColumnInfo(name = "vetstreet_url")
    val vetstreetUrl: String,
    val vocalisation: Int,
    @Embedded
    val weight: Weight,
    @ColumnInfo(name = "wikipedia_url")
    val wikipediaUrl: String

)
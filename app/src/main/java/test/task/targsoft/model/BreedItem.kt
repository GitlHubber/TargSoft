package test.task.targsoft.model

import com.squareup.moshi.Json
import test.task.targsoft.model.Weight

data class BreedItem(
    val adaptability: Int,
    @field:Json(name = "affection_level")
    val affectionLevel: Int,
    @field:Json(name = "alt_names")
    val altNames: String,
    @field:Json(name = "cfa_url")
    val cfaUrl: String,
    @field:Json(name = "child_friendly")
    val childFriendly: Int,
    @field:Json(name = "country_code")
    val countryCode: String,
    @field:Json(name = "country_codes")
    val countryCodes: String,
    val description: String,
    @field:Json(name = "dog_friendly")
    val dogFriendly: Int,
    @field:Json(name = "energy_level")
    val energyLevel: Int,
    val experimental: Int,
    val grooming: Int,
    val hairless: Int,
    @field:Json(name = "health_issues")
    val healthIssues: Int,
    val hypoallergenic: Int,
    val id: String,
    val indoor: Int,
    val intelligence: Int,
    val lap: Int,
    @field:Json(name = "life_span")
    val lifeSpan: String,
    val name: String,
    val natural: Int,
    val origin: String,
    val rare: Int,
    val rex: Int,
    @field:Json(name = "shedding_level")
    val sheddingLevel: Int,
    @field:Json(name = "short_legs")
    val shortLegs: Int,
    @field:Json(name = "social_needs")
    val socialNeeds: Int,
    @field:Json(name = "stranger_friendly")
    val strangerFriendly: Int,
    @field:Json(name = "suppressed_tail")
    val suppressedTail: Int,
    val temperament: String,
    @field:Json(name = "vcahospitals_url")
    val vcahospitalsUrl: String,
    @field:Json(name = "vetstreet_url")
    val vetstreetUrl: String,
    val vocalisation: Int,
    val weight: Weight,
    @field:Json(name = "wikipedia_url")
    val wikipediaUrl: String
)
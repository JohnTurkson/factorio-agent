import com.johnturkson.factorio.models.FactorioReleaseVersionInformation
import kotlinx.serialization.Serializable

@Serializable
data class FactorioReleaseVersion(
    val experimental: FactorioReleaseVersionInformation,
    val stable: FactorioReleaseVersionInformation,
)

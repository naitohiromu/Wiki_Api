package jp.techacademy.origin.app.wiki_api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SNResponse(
    @Json(name = "accountId")
    val accountId: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "profileIconId")
    val profileIconId: Int,
    @Json(name = "puuid")
    val puuid: String,
    @Json(name = "revisionDate")
    val revisionDate: Long,
    @Json(name = "summonerLevel")
    val summonerLevel: Int
)

@JsonClass(generateAdapter = true)
data class MatchData(
    @Json(name = "info")
    val info: Info,
    @Json(name = "metadata")
    val metadata: Metadata
)
class MatchId : ArrayList<String>()

@JsonClass(generateAdapter = true)
data class Info(
    @Json(name = "gameCreation")
    val gameCreation: Long,
    @Json(name = "gameDuration")
    val gameDuration: Int,
    @Json(name = "gameEndTimestamp")
    val gameEndTimestamp: Long,
    @Json(name = "gameId")
    val gameId: Int,
    @Json(name = "gameMode")
    val gameMode: String,
    @Json(name = "gameName")
    val gameName: String,
    @Json(name = "gameStartTimestamp")
    val gameStartTimestamp: Long,
    @Json(name = "gameType")
    val gameType: String,
    @Json(name = "gameVersion")
    val gameVersion: String,
    @Json(name = "mapId")
    val mapId: Int,
    @Json(name = "participants")
    val participants: List<Participant>,
    @Json(name = "platformId")
    val platformId: String,
    @Json(name = "queueId")
    val queueId: Int,
    @Json(name = "teams")
    val teams: List<Team>,
    @Json(name = "tournamentCode")
    val tournamentCode: String
)

@JsonClass(generateAdapter = true)
data class Metadata(
    @Json(name = "dataVersion")
    val dataVersion: String,
    @Json(name = "matchId")
    val matchId: String,
    @Json(name = "participants")
    val participants: List<String>
)

@JsonClass(generateAdapter = true)
data class Participant(
    @Json(name = "allInPings")
    val allInPings: Int,
    @Json(name = "assistMePings")
    val assistMePings: Int,
    @Json(name = "assists")
    val assists: Int,
    @Json(name = "baitPings")
    val baitPings: Int,
    @Json(name = "baronKills")
    val baronKills: Int,
    @Json(name = "basicPings")
    val basicPings: Int,
    @Json(name = "bountyLevel")
    val bountyLevel: Int,
    //@Json(name = "challenges")
    //val challenges: Challenges,
    @Json(name = "champExperience")
    val champExperience: Int,
    @Json(name = "champLevel")
    val champLevel: Int,
    @Json(name = "championId")
    val championId: Int,
    @Json(name = "championName")
    val championName: String,
    @Json(name = "championTransform")
    val championTransform: Int,
    @Json(name = "commandPings")
    val commandPings: Int,
    @Json(name = "consumablesPurchased")
    val consumablesPurchased: Int,
    @Json(name = "damageDealtToBuildings")
    val damageDealtToBuildings: Int,
    @Json(name = "damageDealtToObjectives")
    val damageDealtToObjectives: Int,
    @Json(name = "damageDealtToTurrets")
    val damageDealtToTurrets: Int,
    @Json(name = "damageSelfMitigated")
    val damageSelfMitigated: Int,
    @Json(name = "dangerPings")
    val dangerPings: Int,
    @Json(name = "deaths")
    val deaths: Int,
    @Json(name = "detectorWardsPlaced")
    val detectorWardsPlaced: Int,
    @Json(name = "doubleKills")
    val doubleKills: Int,
    @Json(name = "dragonKills")
    val dragonKills: Int,
    @Json(name = "eligibleForProgression")
    val eligibleForProgression: Boolean,
    @Json(name = "enemyMissingPings")
    val enemyMissingPings: Int,
    @Json(name = "enemyVisionPings")
    val enemyVisionPings: Int,
    @Json(name = "firstBloodAssist")
    val firstBloodAssist: Boolean,
    @Json(name = "firstBloodKill")
    val firstBloodKill: Boolean,
    @Json(name = "firstTowerAssist")
    val firstTowerAssist: Boolean,
    @Json(name = "firstTowerKill")
    val firstTowerKill: Boolean,
    @Json(name = "gameEndedInEarlySurrender")
    val gameEndedInEarlySurrender: Boolean,
    @Json(name = "gameEndedInSurrender")
    val gameEndedInSurrender: Boolean,
    @Json(name = "getBackPings")
    val getBackPings: Int,
    @Json(name = "goldEarned")
    val goldEarned: Int,
    @Json(name = "goldSpent")
    val goldSpent: Int,
    @Json(name = "holdPings")
    val holdPings: Int,
    @Json(name = "individualPosition")
    val individualPosition: String,
    @Json(name = "inhibitorKills")
    val inhibitorKills: Int,
    @Json(name = "inhibitorTakedowns")
    val inhibitorTakedowns: Int,
    @Json(name = "inhibitorsLost")
    val inhibitorsLost: Int,
    @Json(name = "item0")
    val item0: Int,
    @Json(name = "item1")
    val item1: Int,
    @Json(name = "item2")
    val item2: Int,
    @Json(name = "item3")
    val item3: Int,
    @Json(name = "item4")
    val item4: Int,
    @Json(name = "item5")
    val item5: Int,
    @Json(name = "item6")
    val item6: Int,
    @Json(name = "itemsPurchased")
    val itemsPurchased: Int,
    @Json(name = "killingSprees")
    val killingSprees: Int,
    @Json(name = "kills")
    val kills: Int,
    @Json(name = "lane")
    val lane: String,
    @Json(name = "largestCriticalStrike")
    val largestCriticalStrike: Int,
    @Json(name = "largestKillingSpree")
    val largestKillingSpree: Int,
    @Json(name = "largestMultiKill")
    val largestMultiKill: Int,
    @Json(name = "longestTimeSpentLiving")
    val longestTimeSpentLiving: Int,
    @Json(name = "magicDamageDealt")
    val magicDamageDealt: Int,
    @Json(name = "magicDamageDealtToChampions")
    val magicDamageDealtToChampions: Int,
    @Json(name = "magicDamageTaken")
    val magicDamageTaken: Int,
    @Json(name = "needVisionPings")
    val needVisionPings: Int,
    @Json(name = "neutralMinionsKilled")
    val neutralMinionsKilled: Int,
    @Json(name = "nexusKills")
    val nexusKills: Int,
    @Json(name = "nexusLost")
    val nexusLost: Int,
    @Json(name = "nexusTakedowns")
    val nexusTakedowns: Int,
    @Json(name = "objectivesStolen")
    val objectivesStolen: Int,
    @Json(name = "objectivesStolenAssists")
    val objectivesStolenAssists: Int,
    @Json(name = "onMyWayPings")
    val onMyWayPings: Int,
    @Json(name = "participantId")
    val participantId: Int,
    @Json(name = "pentaKills")
    val pentaKills: Int,
    @Json(name = "perks")
    val perks: Perks,
    @Json(name = "physicalDamageDealt")
    val physicalDamageDealt: Int,
    @Json(name = "physicalDamageDealtToChampions")
    val physicalDamageDealtToChampions: Int,
    @Json(name = "physicalDamageTaken")
    val physicalDamageTaken: Int,
    @Json(name = "profileIcon")
    val profileIcon: Int,
    @Json(name = "pushPings")
    val pushPings: Int,
    @Json(name = "puuid")
    val puuid: String,
    @Json(name = "quadraKills")
    val quadraKills: Int,
    @Json(name = "riotIdName")
    val riotIdName: String,
    @Json(name = "riotIdTagline")
    val riotIdTagline: String,
    @Json(name = "role")
    val role: String,
    @Json(name = "sightWardsBoughtInGame")
    val sightWardsBoughtInGame: Int,
    @Json(name = "spell1Casts")
    val spell1Casts: Int,
    @Json(name = "spell2Casts")
    val spell2Casts: Int,
    @Json(name = "spell3Casts")
    val spell3Casts: Int,
    @Json(name = "spell4Casts")
    val spell4Casts: Int,
    @Json(name = "summoner1Casts")
    val summoner1Casts: Int,
    @Json(name = "summoner1Id")
    val summoner1Id: Int,
    @Json(name = "summoner2Casts")
    val summoner2Casts: Int,
    @Json(name = "summoner2Id")
    val summoner2Id: Int,
    @Json(name = "summonerId")
    val summonerId: String,
    @Json(name = "summonerLevel")
    val summonerLevel: Int,
    @Json(name = "summonerName")
    val summonerName: String,
    @Json(name = "teamEarlySurrendered")
    val teamEarlySurrendered: Boolean,
    @Json(name = "teamId")
    val teamId: Int,
    @Json(name = "teamPosition")
    val teamPosition: String,
    @Json(name = "timeCCingOthers")
    val timeCCingOthers: Int,
    @Json(name = "timePlayed")
    val timePlayed: Int,
    @Json(name = "totalAllyJungleMinionsKilled")
    val totalAllyJungleMinionsKilled: Int,
    @Json(name = "totalDamageDealt")
    val totalDamageDealt: Int,
    @Json(name = "totalDamageDealtToChampions")
    val totalDamageDealtToChampions: Int,
    @Json(name = "totalDamageShieldedOnTeammates")
    val totalDamageShieldedOnTeammates: Int,
    @Json(name = "totalDamageTaken")
    val totalDamageTaken: Int,
    @Json(name = "totalEnemyJungleMinionsKilled")
    val totalEnemyJungleMinionsKilled: Int,
    @Json(name = "totalHeal")
    val totalHeal: Int,
    @Json(name = "totalHealsOnTeammates")
    val totalHealsOnTeammates: Int,
    @Json(name = "totalMinionsKilled")
    val totalMinionsKilled: Int,
    @Json(name = "totalTimeCCDealt")
    val totalTimeCCDealt: Int,
    @Json(name = "totalTimeSpentDead")
    val totalTimeSpentDead: Int,
    @Json(name = "totalUnitsHealed")
    val totalUnitsHealed: Int,
    @Json(name = "tripleKills")
    val tripleKills: Int,
    @Json(name = "trueDamageDealt")
    val trueDamageDealt: Int,
    @Json(name = "trueDamageDealtToChampions")
    val trueDamageDealtToChampions: Int,
    @Json(name = "trueDamageTaken")
    val trueDamageTaken: Int,
    @Json(name = "turretKills")
    val turretKills: Int,
    @Json(name = "turretTakedowns")
    val turretTakedowns: Int,
    @Json(name = "turretsLost")
    val turretsLost: Int,
    @Json(name = "unrealKills")
    val unrealKills: Int,
    @Json(name = "visionClearedPings")
    val visionClearedPings: Int,
    @Json(name = "visionScore")
    val visionScore: Int,
    @Json(name = "visionWardsBoughtInGame")
    val visionWardsBoughtInGame: Int,
    @Json(name = "wardsKilled")
    val wardsKilled: Int,
    @Json(name = "wardsPlaced")
    val wardsPlaced: Int,
    @Json(name = "win")
    val win: Boolean
)

@JsonClass(generateAdapter = true)
data class Team(
    @Json(name = "bans")
    val bans: List<Any>,
    @Json(name = "objectives")
    val objectives: Objectives,
    @Json(name = "teamId")
    val teamId: Int,
    @Json(name = "win")
    val win: Boolean
)
/*
@JsonClass(generateAdapter = true)
data class Challenges(
    @Json(name = "abilityUses")
    val abilityUses: Int,
    @Json(name = "acesBefore15Minutes")
    val acesBefore15Minutes: Int,
    @Json(name = "alliedJungleMonsterKills")
    val alliedJungleMonsterKills: Int,
    @Json(name = "12AssistStreakCount")
    val assistStreakCount: Int,
    @Json(name = "baronBuffGoldAdvantageOverThreshold")
    val baronBuffGoldAdvantageOverThreshold: Int,
    @Json(name = "baronTakedowns")
    val baronTakedowns: Int,
    @Json(name = "blastConeOppositeOpponentCount")
    val blastConeOppositeOpponentCount: Int,
    @Json(name = "bountyGold")
    val bountyGold: Int,
    @Json(name = "buffsStolen")
    val buffsStolen: Int,
    @Json(name = "completeSupportQuestInTime")
    val completeSupportQuestInTime: Int,
    @Json(name = "controlWardTimeCoverageInRiverOrEnemyHalf")
    val controlWardTimeCoverageInRiverOrEnemyHalf: Double,
    @Json(name = "controlWardsPlaced")
    val controlWardsPlaced: Int,
    @Json(name = "damagePerMinute")
    val damagePerMinute: Double,
    @Json(name = "damageTakenOnTeamPercentage")
    val damageTakenOnTeamPercentage: Double,
    @Json(name = "dancedWithRiftHerald")
    val dancedWithRiftHerald: Int,
    @Json(name = "deathsByEnemyChamps")
    val deathsByEnemyChamps: Int,
    @Json(name = "dodgeSkillShotsSmallWindow")
    val dodgeSkillShotsSmallWindow: Int,
    @Json(name = "doubleAces")
    val doubleAces: Int,
    @Json(name = "dragonTakedowns")
    val dragonTakedowns: Int,
    @Json(name = "earliestBaron")
    val earliestBaron: Double,
    @Json(name = "earliestDragonTakedown")
    val earliestDragonTakedown: Double,
    @Json(name = "earlyLaningPhaseGoldExpAdvantage")
    val earlyLaningPhaseGoldExpAdvantage: Int,
    @Json(name = "effectiveHealAndShielding")
    val effectiveHealAndShielding: Double,
    @Json(name = "elderDragonKillsWithOpposingSoul")
    val elderDragonKillsWithOpposingSoul: Int,
    @Json(name = "elderDragonMultikills")
    val elderDragonMultikills: Int,
    @Json(name = "enemyChampionImmobilizations")
    val enemyChampionImmobilizations: Int,
    @Json(name = "enemyJungleMonsterKills")
    val enemyJungleMonsterKills: Int,
    @Json(name = "epicMonsterKillsNearEnemyJungler")
    val epicMonsterKillsNearEnemyJungler: Int,
    @Json(name = "epicMonsterKillsWithin30SecondsOfSpawn")
    val epicMonsterKillsWithin30SecondsOfSpawn: Int,
    @Json(name = "epicMonsterSteals")
    val epicMonsterSteals: Int,
    @Json(name = "epicMonsterStolenWithoutSmite")
    val epicMonsterStolenWithoutSmite: Int,
    @Json(name = "fasterSupportQuestCompletion")
    val fasterSupportQuestCompletion: Int,
    @Json(name = "firstTurretKilled")
    val firstTurretKilled: Int,
    @Json(name = "firstTurretKilledTime")
    val firstTurretKilledTime: Double,
    @Json(name = "flawlessAces")
    val flawlessAces: Int,
    @Json(name = "fullTeamTakedown")
    val fullTeamTakedown: Int,
    @Json(name = "gameLength")
    val gameLength: Double,
    @Json(name = "getTakedownsInAllLanesEarlyJungleAsLaner")
    val getTakedownsInAllLanesEarlyJungleAsLaner: Int,
    @Json(name = "goldPerMinute")
    val goldPerMinute: Double,
    @Json(name = "hadAfkTeammate")
    val hadAfkTeammate: Int,
    @Json(name = "hadOpenNexus")
    val hadOpenNexus: Int,
    @Json(name = "highestChampionDamage")
    val highestChampionDamage: Int,
    @Json(name = "highestCrowdControlScore")
    val highestCrowdControlScore: Int,
    @Json(name = "highestWardKills")
    val highestWardKills: Int,
    @Json(name = "immobilizeAndKillWithAlly")
    val immobilizeAndKillWithAlly: Int,
    @Json(name = "initialBuffCount")
    val initialBuffCount: Int,
    @Json(name = "initialCrabCount")
    val initialCrabCount: Int,
    @Json(name = "jungleCsBefore10Minutes")
    val jungleCsBefore10Minutes: Double,
    @Json(name = "junglerKillsEarlyJungle")
    val junglerKillsEarlyJungle: Int,
    @Json(name = "junglerTakedownsNearDamagedEpicMonster")
    val junglerTakedownsNearDamagedEpicMonster: Int,
    @Json(name = "kTurretsDestroyedBeforePlatesFall")
    val kTurretsDestroyedBeforePlatesFall: Int,
    @Json(name = "kda")
    val kda: Double,
    @Json(name = "killAfterHiddenWithAlly")
    val killAfterHiddenWithAlly: Int,
    @Json(name = "killParticipation")
    val killParticipation: Double,
    @Json(name = "killedChampTookFullTeamDamageSurvived")
    val killedChampTookFullTeamDamageSurvived: Int,
    @Json(name = "killingSprees")
    val killingSprees: Int,
    @Json(name = "killsNearEnemyTurret")
    val killsNearEnemyTurret: Int,
    @Json(name = "killsOnLanersEarlyJungleAsJungler")
    val killsOnLanersEarlyJungleAsJungler: Int,
    @Json(name = "killsOnOtherLanesEarlyJungleAsLaner")
    val killsOnOtherLanesEarlyJungleAsLaner: Int,
    @Json(name = "killsOnRecentlyHealedByAramPack")
    val killsOnRecentlyHealedByAramPack: Int,
    @Json(name = "killsUnderOwnTurret")
    val killsUnderOwnTurret: Int,
    @Json(name = "killsWithHelpFromEpicMonster")
    val killsWithHelpFromEpicMonster: Int,
    @Json(name = "knockEnemyIntoTeamAndKill")
    val knockEnemyIntoTeamAndKill: Int,
    @Json(name = "landSkillShotsEarlyGame")
    val landSkillShotsEarlyGame: Int,
    @Json(name = "laneMinionsFirst10Minutes")
    val laneMinionsFirst10Minutes: Int,
    @Json(name = "laningPhaseGoldExpAdvantage")
    val laningPhaseGoldExpAdvantage: Int,
    @Json(name = "legendaryCount")
    val legendaryCount: Int,
    @Json(name = "lostAnInhibitor")
    val lostAnInhibitor: Int,
    @Json(name = "maxCsAdvantageOnLaneOpponent")
    val maxCsAdvantageOnLaneOpponent: Double,
    @Json(name = "maxKillDeficit")
    val maxKillDeficit: Int,
    @Json(name = "maxLevelLeadLaneOpponent")
    val maxLevelLeadLaneOpponent: Int,
    @Json(name = "mejaisFullStackInTime")
    val mejaisFullStackInTime: Int,
    @Json(name = "moreEnemyJungleThanOpponent")
    val moreEnemyJungleThanOpponent: Double,
    @Json(name = "multiKillOneSpell")
    val multiKillOneSpell: Int,
    @Json(name = "multiTurretRiftHeraldCount")
    val multiTurretRiftHeraldCount: Int,
    @Json(name = "multikills")
    val multikills: Int,
    @Json(name = "multikillsAfterAggressiveFlash")
    val multikillsAfterAggressiveFlash: Int,
    @Json(name = "mythicItemUsed")
    val mythicItemUsed: Int,
    @Json(name = "outerTurretExecutesBefore10Minutes")
    val outerTurretExecutesBefore10Minutes: Int,
    @Json(name = "outnumberedKills")
    val outnumberedKills: Int,
    @Json(name = "outnumberedNexusKill")
    val outnumberedNexusKill: Int,
    @Json(name = "perfectDragonSoulsTaken")
    val perfectDragonSoulsTaken: Int,
    @Json(name = "perfectGame")
    val perfectGame: Int,
    @Json(name = "pickKillWithAlly")
    val pickKillWithAlly: Int,
    @Json(name = "poroExplosions")
    val poroExplosions: Int,
    @Json(name = "quickCleanse")
    val quickCleanse: Int,
    @Json(name = "quickFirstTurret")
    val quickFirstTurret: Int,
    @Json(name = "quickSoloKills")
    val quickSoloKills: Int,
    @Json(name = "riftHeraldTakedowns")
    val riftHeraldTakedowns: Int,
    @Json(name = "saveAllyFromDeath")
    val saveAllyFromDeath: Int,
    @Json(name = "scuttleCrabKills")
    val scuttleCrabKills: Int,
    @Json(name = "shortestTimeToAceFromFirstTakedown")
    val shortestTimeToAceFromFirstTakedown: Double,
    @Json(name = "skillshotsDodged")
    val skillshotsDodged: Int,
    @Json(name = "skillshotsHit")
    val skillshotsHit: Int,
    @Json(name = "snowballsHit")
    val snowballsHit: Int,
    @Json(name = "soloBaronKills")
    val soloBaronKills: Int,
    @Json(name = "soloKills")
    val soloKills: Int,
    @Json(name = "soloTurretsLategame")
    val soloTurretsLategame: Int,
    @Json(name = "stealthWardsPlaced")
    val stealthWardsPlaced: Int,
    @Json(name = "survivedSingleDigitHpCount")
    val survivedSingleDigitHpCount: Int,
    @Json(name = "survivedThreeImmobilizesInFight")
    val survivedThreeImmobilizesInFight: Int,
    @Json(name = "takedownOnFirstTurret")
    val takedownOnFirstTurret: Int,
    @Json(name = "takedowns")
    val takedowns: Int,
    @Json(name = "takedownsAfterGainingLevelAdvantage")
    val takedownsAfterGainingLevelAdvantage: Int,
    @Json(name = "takedownsBeforeJungleMinionSpawn")
    val takedownsBeforeJungleMinionSpawn: Int,
    @Json(name = "takedownsFirstXMinutes")
    val takedownsFirstXMinutes: Int,
    @Json(name = "takedownsInAlcove")
    val takedownsInAlcove: Int,
    @Json(name = "takedownsInEnemyFountain")
    val takedownsInEnemyFountain: Int,
    @Json(name = "teamBaronKills")
    val teamBaronKills: Int,
    @Json(name = "teamDamagePercentage")
    val teamDamagePercentage: Double,
    @Json(name = "teamElderDragonKills")
    val teamElderDragonKills: Int,
    @Json(name = "teamRiftHeraldKills")
    val teamRiftHeraldKills: Int,
    @Json(name = "teleportTakedowns")
    val teleportTakedowns: Int,
    @Json(name = "thirdInhibitorDestroyedTime")
    val thirdInhibitorDestroyedTime: Double,
    @Json(name = "tookLargeDamageSurvived")
    val tookLargeDamageSurvived: Int,
    @Json(name = "turretPlatesTaken")
    val turretPlatesTaken: Int,
    @Json(name = "turretTakedowns")
    val turretTakedowns: Int,
    @Json(name = "turretsTakenWithRiftHerald")
    val turretsTakenWithRiftHerald: Int,
    @Json(name = "twentyMinionsIn3SecondsCount")
    val twentyMinionsIn3SecondsCount: Int,
    @Json(name = "twoWardsOneSweeperCount")
    val twoWardsOneSweeperCount: Int,
    @Json(name = "unseenRecalls")
    val unseenRecalls: Int,
    @Json(name = "visionScoreAdvantageLaneOpponent")
    val visionScoreAdvantageLaneOpponent: Double,
    @Json(name = "visionScorePerMinute")
    val visionScorePerMinute: Double,
    @Json(name = "wardTakedowns")
    val wardTakedowns: Int,
    @Json(name = "wardTakedownsBefore20M")
    val wardTakedownsBefore20M: Int,
    @Json(name = "wardsGuarded")
    val wardsGuarded: Int
)
*/
@JsonClass(generateAdapter = true)
data class Perks(
    @Json(name = "statPerks")
    val statPerks: StatPerks,
    @Json(name = "styles")
    val styles: List<Style>
)

@JsonClass(generateAdapter = true)
data class StatPerks(
    @Json(name = "defense")
    val defense: Int,
    @Json(name = "flex")
    val flex: Int,
    @Json(name = "offense")
    val offense: Int
)

@JsonClass(generateAdapter = true)
data class Style(
    @Json(name = "description")
    val description: String,
    @Json(name = "selections")
    val selections: List<Selection>,
    @Json(name = "style")
    val style: Int
)

@JsonClass(generateAdapter = true)
data class Selection(
    @Json(name = "perk")
    val perk: Int,
    @Json(name = "var1")
    val var1: Int,
    @Json(name = "var2")
    val var2: Int,
    @Json(name = "var3")
    val var3: Int
)

@JsonClass(generateAdapter = true)
data class Objectives(
    @Json(name = "baron")
    val baron: Baron,
    @Json(name = "champion")
    val champion: Champion,
    @Json(name = "dragon")
    val dragon: Dragon,
    @Json(name = "inhibitor")
    val inhibitor: Inhibitor,
    @Json(name = "riftHerald")
    val riftHerald: RiftHerald,
    @Json(name = "tower")
    val tower: Tower
)

@JsonClass(generateAdapter = true)
data class Baron(
    @Json(name = "first")
    val first: Boolean,
    @Json(name = "kills")
    val kills: Int
)

@JsonClass(generateAdapter = true)
data class Champion(
    @Json(name = "first")
    val first: Boolean,
    @Json(name = "kills")
    val kills: Int
)

@JsonClass(generateAdapter = true)
data class Dragon(
    @Json(name = "first")
    val first: Boolean,
    @Json(name = "kills")
    val kills: Int
)

@JsonClass(generateAdapter = true)
data class Inhibitor(
    @Json(name = "first")
    val first: Boolean,
    @Json(name = "kills")
    val kills: Int
)

@JsonClass(generateAdapter = true)
data class RiftHerald(
    @Json(name = "first")
    val first: Boolean,
    @Json(name = "kills")
    val kills: Int
)

@JsonClass(generateAdapter = true)
data class Tower(
    @Json(name = "first")
    val first: Boolean,
    @Json(name = "kills")
    val kills: Int
)
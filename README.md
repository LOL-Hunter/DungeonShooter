# DungeonShooter

## Spieler
 * Der Spieler startet mit einer Startausrüstung.
   * minimale Gegenstände
   * Basic Schlagwaffe
 * Er kann eine Primär- und eine Sekundärwaffe ausrüsten.
   * Wahlweise einen Ausrüstungsgegenstand gegen eine Waffe tauschen
 * Der Spieler verliert alle Gegenstände beim Tod. Behällt aber seine Seelen und Baupläne.
 * Er wird beim Tod in den Anfangsraum zurückgesetzt.
   * Alles nochmal mit Monstern und Kisten

## Inventar
 * Hier können Gegenstände gelagert werden.
   * Waffen-Teile eins pro Feld
   * Heilung, Essen etc 10 pro Feld
 * Der Spieler kann im Inventar durch hovern über dem Feld über das Tooltip die Informationen und Werte über den Gegenstand einsehen.
 * Das Inventar kann durch Gegenstände, die in den Truhen gefunden werden können, erweitert werden. meta!
 * Die Herstellung erfolgt im Inventar mithilfe eines Bauplans.
 * Gegenstände können fallengelassen werden?
 * Werden nach einiger Zeit gelöscht?

## Baupläne 
 * Mit Bauplänen können fast alle Gegenstände im Spiel (außer Waffenteile) hergestellt werden. 
 * Der Bauplan ist ein Overlay, das über das Inventar gelegt werden kann.
 * In dieses Overlay müssen dann die Angezeigten bzw. Benötigten Gegenstände einsortiert werden.
 * Der Bauplan kann im linken Bauplanmenu ausgewählt werden.
 * Baupläne müssen in den Kisten gefunden oder gekauft werden.

## Gegenstände
 * Es gibt verschiedene Gegenstände, mit denen sich der Spieler heilen kann.
 * In den Truhen können auch verschiedene Materialien gefunden werden, die zur Herstellung von Gegenständen benötigt werden.
 * Diese Gegenstände können nach Öffnen der Truhe vom Bode aufgehoben werden ?
 * Diese können in folgenden Seltenheiten gefunden werden:
   * Gewöhnlich   (common)
   * Ungewöhnlich (uncommon)
   * Selten       (rare)
   * Episch       (epic)
   * Legendär     (legendary)
   * Mystisch     (mystical) (ggf) meta
 * Die Seltenheit kann an der Hintergrundfarbe des Felds im Inventar erkannt werden.

## Truhen
 * Transformation von der Truhe ins Spielerinventar?
   * Die Items liegen, nach öffnen der Truhe, auf dem Boden und können per Klick eingesammelt werden. 
     * Dann müsste der Spiler das Inventar nach aufsammeln (wieder) sortieren.
     * Beim drüber howern wird der Name in der Farbe der Seltenheit angezeigt.
     * Gibt natürlich eine Reichweite, in der der Spieler auf die Gegenstände Klicken kann.
     * (Wäre schwieriger aber fänd ich cooler.)
   * Truhe hat ein Inventar und die Gegenstände können über das gui transferiert werden.
     * Spieler kann direkt entscheiden, wo der Gegenstand aus der Truhe hinsoll.

## Waffen
 * Es gibt verschiedene Waffentypen, die zusammengebaut werden können und durch austauschen der Waffen-Teilen modifiziert werden können.
 * Die Waffen müssen nachgeladen werden, Munition ist aber unendlich.

## Waffen-Teile
 * Es gibt viele verschiedene Waffenteile, die der Waffe des Spielers und dem Spieler selbst Vor- und Nachteile bieten.
 * Jeder Typ eines Teils hat die gleichen Vor- und Nachteile plus 1-3 zufällige Eigenschaften.
 * Die Teile können in verschiedenen Seltenheiteten gefunden werden.
 * Die Teile einer Waffe können ersetzt werden.

## Effekte ?
 * Der Spieler kann durch Trank-Gegenstände verschiedene Effekte erhalten:
   * Stärke (mehr Schaden)
   * Schnelligkeit (höhere Geschwindigkeit)
   * Crit (höhere Critchance)
   * Seelen (doppelte Seelen)
   * Plünderung (höhere Warscheinlichkeit Gegenstände fallen zu lassen)
 * Diese Tränke können gefunden werden oder per Bauplan hergestellt werden.

## Dungeon
 * Im Startraum (1x1 Raum) befindet sich ein Händler und eine Falltür, um in die nächste Ebene zu kommen.
 * Es kann nicht in die vorherigen Ebenen gegangen werden.
 * Die Schwierigkeit steigt, je niedriger die Ebene des Spielers.
 * Der Dungeon hat mehrere Ebenen die 5x5 Räume haben.
 * Die Boss-Ebene hat 3x3 Räume die miteinander Verbunden sind.
 * Die Ebenen, Truhen, Schlüssel und Falltüren werden zufällig in der Ebene generiert.
 * In jedem Dungeon befinden sich Schätze in Truhen und ein Schlüssel zur Falltür in die nächste Ebene.
 * Es kann die ganze Ebene erkundet und gelootet werden, muss aber nicht, solange man die Falltür und den Schlüssel findet.

## Dungeon-Schwierigkeit
 * Sie muss im Vorhinein eingestellt werden:
   * Leicht
   * Mittel
   * Schwer
   * Höllisch
 * Sie beeinflusst die Schelligkeit, Schaden der Monster.
 * Anzahl der Truhen, Warscheinlichkeit seltene Items zu bekommen
 * Drop-rate, Seelen

## Monsters
 * Es werden verschiedene Monster mit unterschiedlichen Nah- und Fernkampf angriffen.
 * Wenn das Monster nicht aus der Ferne mit einem Schlag getötet wird, alamiert es die umliegenden Monster.
 * Hat das Monster den Spieler einmal entdeckt, verfolgt es den Spieler.
 * Wie weit ein Monster den Spieler sehen und höhren kann, kann per Waffen-Teile verändert werden.
 * Es besteht die geringe Chance, dass Monster auch Gegenstände fallen lassen.
 * Ein Monster lässt immer seine Seele fallen.

## Bosse 
 * Alle 5 Ebenen muss ein Boss besiegt werden.
 * Es gibt Verschiedene Boss-Arten
 * Der Boss hat verschiedene Angriffe
 * Wenn der Boss besiegt wurde lässt er einen Schlüssel für die nächste Ebene und eine Truhe mit wertvollen Gegenständen fallen.

## Händler
 * Hin und wieder taucht ein Händler auf, der Seelen für Items eintauscht.
 * Und im Anfangsraum ist ein Händler zu finden.

## Mehrspieler
 * Es kann local oder über einen offenen Port ein Mehrspieler-Server gehostet werden.
 * Es dadurch im Team gespielt werden. (warscheinlich nur max zu zweit spielbar)
 * Der Spielstand beider Spieler wird local auf dem Host-Pc gespeichert.
 * Gefundene Baupläne werden für beide Spieler feigeschaltet.
 * PvP kann De- und Aktiviert werden.

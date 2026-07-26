import math

class GeoPoint:
    def __init__(self, lat=0, long=0, desc='TBD'):
        self.__lat = lat
        self.__long = long
        self.__description = desc
    def SetPoint(self, point):
        self.__lat, self.__long = point
    def GetPoint(self):
        return [self.__lat, self.__long]
    def Distance(self, toPoint):
        R = 6371
        φ1 = toPoint[0]*math.pi/180
        φ2 = self.__lat*math.pi/180
        Δφ = (self.__lat-toPoint[0])*math.pi/180
        Δλ = (self.__long-toPoint[1])*math.pi/180
        a = math.sin(Δφ/2)*math.sin(Δφ/2)+math.cos(φ1)*math.cos(φ2)*math.sin(Δλ/2)*math.sin(Δλ/2)
        c = 2*math.atan2(math.sqrt(a), math.sqrt(1-a))
        d = R*c
        return round(d, 2)
    def SetDescription(self, description):
        self.__description = description
    def GetDescription(self):
        return self.__description
    Point = property(GetPoint, SetPoint)
    Description = property(GetDescription, SetDescription)
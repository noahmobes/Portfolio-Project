# MoberlyP7
# Programmer: Noah Moberly
# Email: nmoberly@cnm.edu
# Purpose: To calculate which point of two points is closer to the user

import math

class GeoPoint:
    def __init__(self):
        self.lat = 0
        self.long = 0
        self.description = ''
    def SetPoint(self, lat, long):
        self.lat = lat
        self.long = long
    def GetPoint(self):
        return [self.lat, self.long]
    def Distance(self, lat, long):
        R = 6371
        φ1 = lat*math.pi/180
        φ2 = self.lat*math.pi/180
        Δφ = (self.lat-lat)*math.pi/180
        Δλ = (self.long-long)*math.pi/180
        a = math.sin(Δφ/2)*math.sin(Δφ/2)+math.cos(φ1)*math.cos(φ2)*math.sin(Δλ/2)*math.sin(Δλ/2)
        c = 2*math.atan2(math.sqrt(a), math.sqrt(1-a))
        d = R*c
        return round(d, 2)
    def SetDescription(self, description):
        self.description = description
    def GetDescription(self):
        return self.description
    
# Creating points in Paris and Bangkok
point1 = GeoPoint()
point2 = GeoPoint()

# Setting coordinates and descriptions of points
point1.SetPoint(48.867389, 2.296320) 
point1.SetDescription('Paris')

point2.SetPoint(13.797552, 100.613255)
point2.SetDescription('Bangkok')

# Creating loop for user input
run = 'y'
while run == 'y':
    # Getting the user's location
    user_lat = int(input('Please input your latitude: '))
    user_long = int(input('Please input your longitude: '))
    user_desc = str(input('Describe your location: '))

    # Calculating the user's distance from each point
    distance_from_point1 = point1.Distance(user_lat, user_long)
    distance_from_point2 = point2.Distance(user_lat, user_long)
    
    # Determining which point is closer and printing results
    if distance_from_point1 > distance_from_point2:
        print(f'You are closest to {point2.GetDescription()}, which is located at {point2.GetPoint()}')
    elif distance_from_point2 > distance_from_point1:
        print(f'You are closest to {point1.GetDescription()}, which is located at {point1.GetPoint()}')
    elif distance_from_point1 == distance_from_point2:
        print(f'{point1.GetDescription()} and {point2.GetDescription()} are equally distant from you.')
    print(f'You are {distance_from_point1}km from Paris.')
    print(f'You are {distance_from_point2}km from Bangkok.')
    run = input('Do another (Y/N)? ').lower()
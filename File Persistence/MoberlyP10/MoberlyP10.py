# MoberlyP10
# Programmer: Noah Moberly
# Email: nmoberly@cnm.edu
# Purpose: To wrtie and read a file

from GeoPoint import GeoPoint

# Creaing and/or writing to file
l = open('locations.txt', 'w')
l.write(
    '48.867389, 2.296320, Paris' '\n'
    '13.797552, 100.613255, Bangkok' '\n'
    '51.532789, -0.194304, London' '\n'
    '39.917350, 116.381360, Beijing' '\n'
    '40.727901, -74.005660, New York' '\n'
        )
l.close()

# Opening file
l = open('locations.txt', 'r')
l2 = l.readlines()
l.close()

# Creating list of points
pointList = []
for line in l2:
    this = line.split(', ')
    pointList.append(GeoPoint(float(this[0]), float(this[1]), this[2]))


# print(pointList)

# Creating point in Paris
point1 = GeoPoint(48.867389, 2.296320, 'Paris')

# Creating point in Bangkok
point2 = GeoPoint()
point2.Point = 13.797552, 100.613255
point2.Description = 'Bangkok' 

# Creating loop for user input
while True:
    # Getting the user's location
    try:
        user_lat = float(input('Please input your latitude: '))
        user_long = float(input('Please input your longitude: '))
        user_desc = str(input('Describe your location: '))
    except ValueError as type:
        print(f'{type}, please try again.')
        continue

    # Creating user point
    user_point = GeoPoint(user_lat, user_long, user_desc)

    # Calculating which point the user is closest to

    smallest = 100000000000000000000000
    for point in pointList:
        if point.Distance(user_point.Point) < smallest:
            smallest = point.Distance(user_point.Point)
            closest = point
    print(f'You are closest to {closest.Description} at {closest.Point}')

    # Continue to run?
    run = ''
    while run != 'y' and run != 'n':
        run = input('Do another (Y/N)? ').lower()
    if run == 'y':
        continue
    elif run == 'n':
        break
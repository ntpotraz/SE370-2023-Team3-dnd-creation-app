import json

with open('spells.json', 'r') as json_file:
    data = json.load(json_file)
spellList = []


# Now you can access the data as a Python object
for value in data['spell']:
    if value['level'] == 0 or value['level'] == 1:
        spellList.append(value)

with open('1stspellsCantrips.json', 'w') as json_file:
    json.dump(spellList, json_file, indent=4)

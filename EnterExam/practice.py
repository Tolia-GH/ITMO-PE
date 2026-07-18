import pickle

d = dict(name='Bob', age=20, score=88)
f = open('dump.pkl', 'wb')
pickle.dump(d, f)
f.close()

f = open("dump.pkl", 'rb')
d = pickle.load(f)
f.close()

print(d)
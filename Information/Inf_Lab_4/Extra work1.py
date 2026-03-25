import yaml
import json
from time import *


def yaml_to_json(infile, outfile):
    with open(infile, 'r', encoding='utf-8') as f_in:
        content = yaml.safe_load(f_in)

    with open(outfile, 'w', encoding='utf-8') as f_out:
        json.dump(content, f_out, indent=2, ensure_ascii=False)


start_time = time()
yaml_to_json("source file.yml", "output file2.json")
end_time = time()
print("\n---finish in %s---" % (end_time-start_time))

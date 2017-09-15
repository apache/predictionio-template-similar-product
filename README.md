# Similar Product Template

## Documentation

Please refer to
http://predictionio.incubator.apache.org/templates/similarproduct/quickstart/

## Versions

### v0.12.0-incubating

- Bump version number to track PredictionIO version
- Sets default build targets according to PredictionIO
- Fix warnings and use of case class

### v0.11.0-incubating

- Bump version number to track PredictionIO version
- Rename Scala package name
- Update SBT version

### v0.4.0

Update for Apache PredictionIO 0.10.0-incubating

### v0.3.2

- Fix CooccurrenceAlgorithm with unknown item ids

### v0.3.1

- Add CooccurrenceAlgorithm.
  To use this algorithm, override `engine.json` by `engine-cooccurrence.json`,
  or specify `--variant engine-cooccurrence.json` parameter for both `$pio train` **and**
  `$pio deploy`

### v0.3.0

- update for PredictionIO 0.9.2, including:

  - use new PEventStore API
  - use appName in DataSource parameter


### v0.2.0

- update build.sbt and template.json for PredictionIO 0.9.2

### v0.1.3

- cache mllibRatings RDD in algorithm train() because it is used at multiple places (non-empty data check and ALS)

### v0.1.2

- update for PredictionIO 0.9.0

### v0.1.1

- Persist RDD to memory (.cache()) in DataSource for better performance
- Use local model for faster serving.

### v0.1.0

- initial version


## Development Notes

### import sample data

```
$ python data/import_eventserver.py --access_key <your_access_key>
```

### sample query

normal:

```
curl -H "Content-Type: application/json" \
-d '{ "items": ["i1", "i3", "i10", "i2", "i5", "i31", "i9"], "num": 10}' \
http://localhost:8000/queries.json \
-w %{time_connect}:%{time_starttransfer}:%{time_total}
```

```
curl -H "Content-Type: application/json" \
-d '{
  "items": ["i1", "i3", "i10", "i2", "i5", "i31", "i9"],
  "num": 10,
  "categories" : ["c4", "c3"]
}' \
http://localhost:8000/queries.json \
-w %{time_connect}:%{time_starttransfer}:%{time_total}
```

```
curl -H "Content-Type: application/json" \
-d '{
  "items": ["i1", "i3", "i10", "i2", "i5", "i31", "i9"],
  "num": 10,
  "whiteList": ["i21", "i26", "i40"]
}' \
http://localhost:8000/queries.json \
-w %{time_connect}:%{time_starttransfer}:%{time_total}
```

```
curl -H "Content-Type: application/json" \
-d '{
  "items": ["i1", "i3", "i10", "i2", "i5", "i31", "i9"],
  "num": 10,
  "blackList": ["i21", "i26", "i40"]
}' \
http://localhost:8000/queries.json \
-w %{time_connect}:%{time_starttransfer}:%{time_total}
```

unknown item:

```
curl -H "Content-Type: application/json" \
-d '{ "items": ["unk1", "i3", "i10", "i2", "i5", "i31", "i9"], "num": 10}' \
http://localhost:8000/queries.json \
-w %{time_connect}:%{time_starttransfer}:%{time_total}
```


all unknown items:

```
curl -H "Content-Type: application/json" \
-d '{ "items": ["unk1", "unk2", "unk3", "unk4"], "num": 10}' \
http://localhost:8000/queries.json \
-w %{time_connect}:%{time_starttransfer}:%{time_total}
```

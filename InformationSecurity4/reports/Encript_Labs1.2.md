<head>
  <script src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML" type="text/javascript"></script>
  <script type="text/x-mathjax-config">
    MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
      inlineMath: [['$','$']]
      }
    });
  </script>
</head>

## [MainPage](../../../index.md)/[Info Security](../../README.md)/Encript Lab 1.2

<center>
<p>Университет ИТМО<br>Факультет ФПИ и КТ</p>
<br><br><br><br><br><br>
<h3>Отчёт по лабораторной работе 2</h3>
<h2>«Блочное симметричное шифрование»</h2>
по дисциплину
<h5>«Информационная безопасность»</h5>
</center>

<br><br><br><br><br><br><br><br>

<div align="right">Студент: Чжоу Хунсян</div>
<div align="right">Группа: P34131</div>
<div align="right">Преподаватель:</div>

<center>
<br><br>
<p>Санкт-Петербург 2024</p>
<br>
</center>

---

## Цель работы

изучение структуры и основных принципов работы современных алгоритмов блочного симметричного шифрования, приобретение навыков программной реализации блочных симметричных шифров. 

## Варианты заданий

> Вариант: 23 % 10 = 3

Алгоритм: RC6
Режим шифрования: ECB, CBC, PCBC

## Исходный код

Основные параметры для RC6

```python
W = 32  # Длина слов
R = 20  # Количества цикл
BLOCK_SIZE = 16  # Размер блоков (Bytes)
```

Операция вращения для шифрования RC6

```python
# Операция вращения бита влево
def rotate_left(x, n, w=W):
    return ((x << n) & ((1 << w) - 1)) | (x >> (w - n))


# Операция вращения бита вправо
def rotate_right(x, n, w=W):
    return (x >> n) | ((x << (w - n)) & ((1 << w) - 1))
```

Расширение ключ

```python
def key_schedule(key: bytes) -> List[int]:
    P32 = 0xB7E15163
    Q32 = 0x9E3779B9
    S = [P32]
    for i in range(1, 2 * R + 4):
        S.append((S[i - 1] + Q32) & ((1 << W) - 1))

    L = [int.from_bytes(key[i:i + 4], 'little') for i in range(0, len(key), 4)]
    if len(L) * 4 < len(key):
        L.append(0)

    v = max(len(L), len(S))
    A = B = i = j = 0
    for _ in range(3 * v):
        A = S[i] = rotate_left((S[i] + A + B) & ((1 << W) - 1), 3)
        B = L[j] = rotate_left((L[j] + A + B) & ((1 << W) - 1), (A + B) % W)
        i = (i + 1) % len(S)
        j = (j + 1) % len(L)
    return S
```

Шифрование RC6

```python
# Шифрование RC6
def rc6_encrypt_block(block: bytes, S: List[int]) -> bytes:
    A, B, C, D = struct.unpack('<IIII', block)
    B = (B + S[0]) & ((1 << W) - 1)
    D = (D + S[1]) & ((1 << W) - 1)
    for i in range(1, R + 1):
        t = rotate_left((B * (2 * B + 1)) & ((1 << W) - 1), 5)
        u = rotate_left((D * (2 * D + 1)) & ((1 << W) - 1), 5)
        A = (rotate_left(A ^ t, u % W) + S[2 * i]) & ((1 << W) - 1)
        C = (rotate_left(C ^ u, t % W) + S[2 * i + 1]) & ((1 << W) - 1)
        A, B, C, D = B, C, D, A
    A = (A + S[2 * R + 2]) & ((1 << W) - 1)
    C = (C + S[2 * R + 3]) & ((1 << W) - 1)
    return struct.pack('<IIII', A, B, C, D)
```

Дешифрование RC6

```python
def rc6_decrypt_block(block: bytes, S: List[int]) -> bytes:
    A, B, C, D = struct.unpack('<IIII', block)
    C = (C - S[2 * R + 3]) & ((1 << W) - 1)
    A = (A - S[2 * R + 2]) & ((1 << W) - 1)
    for i in range(R, 0, -1):
        A, B, C, D = D, A, B, C
        u = rotate_left((D * (2 * D + 1)) & ((1 << W) - 1), 5)
        t = rotate_left((B * (2 * B + 1)) & ((1 << W) - 1), 5)
        C = rotate_right((C - S[2 * i + 1]) & ((1 << W) - 1), t % W) ^ u
        A = rotate_right((A - S[2 * i]) & ((1 << W) - 1), u % W) ^ t
    D = (D - S[1]) & ((1 << W) - 1)
    B = (B - S[0]) & ((1 << W) - 1)
    return struct.pack('<IIII', A, B, C, D)
```

Заполнение данных

Алгоритм блочного симметричного шифрования требует, чтобы длина данных открытого текста в байтах была целым кратным размеру блока, поэтому мы должны дополнять данные открытого текста перед шифрованием данных открытого текста.

Здесь мы применяем алгоритм PKCS#7
```python
def pad(data: bytes, block_size: int) -> bytes:
    padding_len = block_size - len(data) % block_size
    return data + bytes([padding_len] * padding_len)


# Удаление заполнения данных
def unpad(data: bytes) -> bytes:
    return data[:-data[-1]]
```

Режим：ECB

```python
def encrypt_ecb(data: bytes, key: bytes) -> bytes:
    S = key_schedule(key)
    data = pad(data, BLOCK_SIZE)
    encrypted = b""
    for i in range(0, len(data), BLOCK_SIZE):
        encrypted += rc6_encrypt_block(data[i:i + BLOCK_SIZE], S)
    return encrypted


def decrypt_ecb(data: bytes, key: bytes) -> bytes:
    S = key_schedule(key)
    decrypted = b""
    for i in range(0, len(data), BLOCK_SIZE):
        decrypted += rc6_decrypt_block(data[i:i + BLOCK_SIZE], S)
    return unpad(decrypted)
```

Режим：CBC

```python
def encrypt_cbc(data: bytes, key: bytes, iv: bytes) -> bytes:
    S = key_schedule(key)
    data = pad(data, BLOCK_SIZE)
    encrypted = b""
    prev = iv
    for i in range(0, len(data), BLOCK_SIZE):
        block = bytes(a ^ b for a, b in zip(data[i:i + BLOCK_SIZE], prev))
        encrypted_block = rc6_encrypt_block(block, S)
        encrypted += encrypted_block
        prev = encrypted_block
    return encrypted


def decrypt_cbc(data: bytes, key: bytes, iv: bytes) -> bytes:
    S = key_schedule(key)
    decrypted = b""
    prev = iv
    for i in range(0, len(data), BLOCK_SIZE):
        block = rc6_decrypt_block(data[i:i + BLOCK_SIZE], S)
        decrypted += bytes(a ^ b for a, b in zip(block, prev))
        prev = data[i:i + BLOCK_SIZE]
    return unpad(decrypted)
```

Режим：PCBC
```python
def encrypt_pcbc(data: bytes, key: bytes, iv: bytes) -> bytes:
    S = key_schedule(key)
    data = pad(data, BLOCK_SIZE)
    encrypted = b""
    prev_enc = iv
    prev_plain = iv
    for i in range(0, len(data), BLOCK_SIZE):
        block = bytes(a ^ b ^ c for a, b, c in zip(data[i:i + BLOCK_SIZE], prev_plain, prev_enc))
        encrypted_block = rc6_encrypt_block(block, S)
        encrypted += encrypted_block
        prev_enc, prev_plain = encrypted_block, data[i:i + BLOCK_SIZE]
    return encrypted


def decrypt_pcbc(data: bytes, key: bytes, iv: bytes) -> bytes:
    S = key_schedule(key)
    decrypted = b""
    prev_enc = iv
    prev_plain = iv
    for i in range(0, len(data), BLOCK_SIZE):
        block = rc6_decrypt_block(data[i:i + BLOCK_SIZE], S)
        decrypted_block = bytes(a ^ b ^ c for a, b, c in zip(block, prev_plain, prev_enc))
        decrypted += decrypted_block
        prev_enc, prev_plain = data[i:i + BLOCK_SIZE], decrypted_block
    return unpad(decrypted)


# Чтение файла
def read_file(filename):
    with open(filename, 'r', encoding='UTF-8') as file:
        return file.read()


# Запись файла
def write_file(filename, content):
    with open(filename, 'w', encoding='UTF-8') as file:
        file.write(content)


# Основная функция
if __name__ == "__main__":
    key_input = input("Please input keyword: ")
    # key = b"thisisakey123456" # 16 bytes Ключ
    key = key_input.encode('utf-8')
    iv = b"initialvector1234" # 16 bytes Вектор
    text = read_file("plaintext.txt")
    plaintext = text.encode('utf-8')
    print("PlainText:\n", plaintext.decode('utf-8'))

    print()

    ecb_encrypted = encrypt_ecb(plaintext, key)
    print("ECB Encrypt:\n", ecb_encrypted.hex())
    print("ECB Decrypt:\n", decrypt_ecb(ecb_encrypted, key).decode('utf-8'))

    print()

    cbc_encrypted = encrypt_cbc(plaintext, key, iv)
    print("CBC Encrypt:\n", cbc_encrypted.hex())
    print("CBC Decrypt:\n", decrypt_cbc(cbc_encrypted, key, iv).decode('utf-8'))

    print()

    pcbc_encrypted = encrypt_pcbc(plaintext, key, iv)
    print("PCBC Encrypt:\n", pcbc_encrypted.hex())
    print("PCBC Decrypt:\n", decrypt_pcbc(pcbc_encrypted, key, iv).decode('utf-8'))
```

## Результаты работы программы

Пример Usage
```
"/Users/2398768715qq.com/GitHub/ITMO-Labs/InfoSecurity/Lab1.2/Lab2 RC6/.venv/bin/python" /Users/2398768715qq.com/GitHub/ITMO-Labs/InfoSecurity/Lab1.2/Lab2 RC6/RC6.py 
Please input keyword: КЛЮЧ
PlainText:
 В рамках нашей работы мы определили следующую методологическую базу:
Сначала мы провели тщательный анализ существующих решений по дизайну интерфейса. Это включало изучение текущих тенденций, оценку пользовательского опыта и анализ преимуществ и недостатков различных подходов.
На основе результатов анализа мы разработали теоретическую модель. Эта модель включала ключевые элементы, которые, по нашему мнению, могут улучшить дизайн интерфейса и повысить его эффективность. Мы также рассматриваем принципы удобства использования и эргономики.
С помощью разработанной модели мы приступили к экспериментальному проектированию. Был создан прототип интерфейса, который включал в себя все ключевые элементы и инновации, предложенные в нашей теоретической модели.
Заключительным этапом было тестирование созданного прототипа. Мы провели серию тестов с участием конечных пользователей, чтобы оценить его эффективность и удобство. Результаты тестирования позволили нам сделать выводы о жизнеспособности нашей модели и предложить рекомендации по дальнейшему улучшению дизайна интерфейса.

ECB Encrypt:
 0d03d15fe59e7b4752bbfff82e91d052b4f54fc423ebec1eeb8f02d059346ec3531753926d45770d14d834d3bc999de9303ab7899519186cd93685cc5e923ef6899b20828a08bc50e31c16036aa15a6c9ec16f0e8c623cfecc4941c025a4defc39e7e968b5329545e313a757fad8ad85adb9c20023c383197fd1cab9f6bb63d4e0a0aa20cd3a6fbc9e5805bd9d6b4b45a58dc1815951e38eefe8073dac06478f75b4446b071986b418bb407017863a2620c7e73a01f8ba9c28eee87b837b5aa61cff7751672bcea74ff89eccf63ca5d19dbac50521ce294b7bdb151778315bc8c0411ac94a12d34f2e07344ebe909edcb9e6d27331e01a3113ae75f3bf6cb694b1076bb8a6505e055f857a8b1d28b44792e82bdd5227c899aaf6746e04e727927dea0a19178e77b8c27d80a7e2ea511103bdd9b8b2150ca2b0bd43368db591b27db4baf3fcf50beeb7041b9e5f59cf4842f9ed80c2bc700b49e2e6ab840ff9e18349165c710c681a6613b35fa2537ad0e58a434b9d45acba73c0c891d6d75963e2d763b2684358fa8c4349431c709bdf7f3fe0f1164690eac41dc4dcbf96cff876a1443b633e05a376c7420380c4c0a04bb6585aef24c87dfe78e6e95c320171341031abfaf45d5ca88d69911b290ee538ca878765ae617ae8bb93578e7251a2a544cfac0fbd0e94ebc93efc8a84dbef85cb7f34587c75b0f5051d6579eca6397c068e157455597bd93d8cd86c8790900fb5d6254eaf98105a7985a47b30430d3e0cdeeb0145079119d5259a6ca6ea8cead0874df6a465106cb0a542b0a39486a5d43c52eb92584f9288a33ed0ecf5404c9ab482d75dfd975e72ef095fab8fffbad2a3a03933dfec3809986138286f533ac81a8e33b788a6624932dc02e9ef1b37447ed210d6c8a93b1fb5e04df1f23829e1e231e8e258b8f28a5c90a33f841d3dc23aee98db9e3f119d5e7bfdcc682bfa1745d93e424bb2c55213da0852126d931102baf2ebd53a2883d2e5e65961543d18595ae6fc98a79e4faeecb6282b295356e2dd25cdb29eda3ce2da90241da4fdabb59ebee280501170cf39308492cd6a7837f4551cb9a2e648301cf129a59f29b522fa60d11ef679a80925f5e66232a621d5b60087f7dade101641bc8391fe2091199382c2fe2e13c4803222172e7f46d383affd27511c9428e4839505b933e126e8ecffccace619eb8f44ecab2c5b23d298158b9e4f7d64a2376fe95ca94c7648b20010c14f7681b09e9e9f373930b4524a984a4fb9cab18d2ee3558a3c802d698bee89064813ac02b79d1329deb30ab23d938b5e2f58748d97ee191e31040c72e9ca273c8e6d1bf908afeab1f056235466b0399722fff731b0b59a01bb3c484f39fadd1d7f331c90d873e918f86c8388981206aaff50ead040ed0a5d9bd7542417f4177beb592089ef7335feeb4fa5d43c52eb92584f9288a33ed0ecf540883d07cc918dd0b6089f029cea563afb3a9c74dd0f2ca1f3da1e3894735c425335974a1124a349f2232d694ef758f1d55a8519bb39cb61b29b81907c0a80d57fc781aafd509298587a22ae1882028638d45dac80aa83e48297656e262cfb128853d25699491dfbc8c8eadde693ab713c564114e94ead787558039213588520d1eeae77edf2b32de24ce42cad28b04bbd98207b76ddb27c77874fa661abc3ef58b6597f616043c2637ded80afb94aaec8248e9af8234c7311c610c478ec5cde67159c9f44f62894957d5b1ab1536099397cddb7260d36f3c097b3158114f75a4dfb76ae3de690b8917e35f0a5f824241923f032d93e525ac20f10053a17ca3ceddc8e1468aa77e46b91490dd82ec9910c5c2447cb734658b1813c132c6773123827dad994b83b0ccdda42df75ad12005a31499b1364bde9f9edeee49815f9cf8cf54cd8785ddb0cbc62b48684d3392543d0e8b1bcb260a8cf6e8c935c1070d3f8890a9ddb7b72d09a70ef4faf2e0d26f7323c767ba13d1749752403512c3ac0a25bd16b8e62b60f6b7f09fe31116ab0f118cbdcf872c45023dac5e0abcbea2900f28dedf4ad99b4fc89bfe5818e0ba8e1f430ee24bb63cef01b7c79604af143b99ea94b19da814fd5db148343c8f4aa3b5673fe14ca3fbe9edb9784875b77423fe6bfda8aaf0a37c1a9838eec927bc57cda159e915e2bcbfea305430b46adc6f645075642b470d02688ee795abfa8cf8496f00f432ae5ce7db3b3367d8330bc5ccb639f05cb71c38d5a02ab54ca8c557568875e3a215607322b11ecac21ced61c28922cde7fac984fe53228b40d9509d1f1aa9e7f77d686dcd3663a959b79a0c2141b95fbb0cc01cfacfe46dac272ae9353d31efcd52e3c329f41304a1cd01f9f82b36ee1b382cb2cbad100079181142b80e1fc83b1adb25a9d0da0f62c347ac6d2542db143b267ffd09685183401e02d5291ddaf80ce47c770e637783057ecc2728ab67746c2e0397920162179a8419e29c66678e6bdf75b1d2bd3ec961281dd90aab91c329a678659701737576d13c171114a94ea2312bdad5910e210b7dbd40577c5ffc4ff8c06884559ccc425fb6edc828d8865a904f89801bd72119a271bf582bd546f9019a390ed703fd3e858b23c561148ae29baf043670db62101c544f49ff8b940e396b0865099916d13696af634dcce431576de00cec9339e28fc01fe29fc17675890466a011e0a073256383fa97973eeb5fc21fe61e4cca066a0592e859fb16a6dc19ff233e1c40524615ee4096ad9ea242584977085b97f148bed3aa6a6e65d8289608ea49396eb16d7797f3ac5fa11d442642d9e01f4a0cdf2e5c02e4baddcacceed03e63f1ccaf5e257
ECB Decrypt:
 В рамках нашей работы мы определили следующую методологическую базу:
Сначала мы провели тщательный анализ существующих решений по дизайну интерфейса. Это включало изучение текущих тенденций, оценку пользовательского опыта и анализ преимуществ и недостатков различных подходов.
На основе результатов анализа мы разработали теоретическую модель. Эта модель включала ключевые элементы, которые, по нашему мнению, могут улучшить дизайн интерфейса и повысить его эффективность. Мы также рассматриваем принципы удобства использования и эргономики.
С помощью разработанной модели мы приступили к экспериментальному проектированию. Был создан прототип интерфейса, который включал в себя все ключевые элементы и инновации, предложенные в нашей теоретической модели.
Заключительным этапом было тестирование созданного прототипа. Мы провели серию тестов с участием конечных пользователей, чтобы оценить его эффективность и удобство. Результаты тестирования позволили нам сделать выводы о жизнеспособности нашей модели и предложить рекомендации по дальнейшему улучшению дизайна интерфейса.

CBC Encrypt:
 94a44009bfbe5237f776604d37d120c860f3210957f6f0fbb313e5900690ddc5bf5105123aa6ebd935769567f5a8a593819ea0fc1c40cdae76351604988ff754a0b0629c07a6f0abd01c533a2016d69426feb5dce1e71ceebe57c9ec9d302a0e919bb2df07fd7726b79877c537e1398075350a430feb778b8da0e0009fa31110189a1902da96fa135f9400d5afebd6ef2fb130b9b743d1c2c1c5143807ca04484691abc5936dcbfdab4c23734bd7cbefb5526d55645ad9fe09419d488cd38c9909bebbaf77451a1498d81624645de5a4de2fee3b5325c660acc73717e6b1f5b4619f16a4aba405105cb14ea5b4b7f516f712601a2ef51ea78b275c12a44e7734d221c429da142e5085d9abc21492a7ee37514847e9e9eba8895bc58eccdbf69fae82643714996586330b509de976afbf4ca494c2ed55962527b09c90209dc6aa26af30973e02977f7dbc25ac4b7934311449e36ecbd30d0241dd28fb69f7c02b63cc0e3f58e909b46cac5bf3a6e5d03916a473bd984530e76835ab4fb1c4a2902ef90693cdd1e6b9e28a03e75e6195dd5fd178c081b07934dd38458e8038ddbbd081a2ed8cac439d47cb104a562771f3227df0f874fd833255472e7991679620e6d42bc3e77c67e43a0fb93f4432f485813f40dbb9bebc2d21c6a1ca5957fe8352b727f5714e5d4b9f15ef1042127c141d48e29ddfb152782d0779980958b86d2bab8ef4b823230ff37589d2627ccd09bf65f73b2ec1c8660b87d782a1fc9af05370e15086e05923e8d751e26a51cb51e293d325a5a98343a67cba54d0ff9bc1ea313d51e5f923a7d86e60c5be9014713addcc2c1eb047856162b01de68b2f22d88a6dd97cdb8cbc28eca3e1459158c3fd755b4480c14778f80623071dc0299d0938df260e64660eb0b981ef14fd4a8e0ad36e2b5f175d8b72e1b923e80382895fa309e37f2850a3bc222cb2fc027dfb4887fa7ee89b3cd69ae9d3059b461844ebf9980c8358d84eccabd3b5cdf5492c5f8b9560b3b1d913f7ecd2d321116cccf22825c5bcb07243d93bd610e41f2438ce0cda859e422a12c6df3a0fe15d7d5c2c00a1b045f659a197d09c6d56be85a74b582d4dc549af7a64d552493d3c1d6c6aa73eb07972710fe4e95cb6b3a365ec2f7d58b316344b006c52ad54d780b8a644f98f176970b908575b68fe25849d1b751f68e7a653b8819e274ec7d974d40df97ad7863f763ac4d8b13ceaeeeb27f61f5f2d11b3455d64f70d14d9427f6b3467d041bab61fa1d5ec60ec7f5a55e0bf3c09f39d69e9c8aa6669f5c4e42c23d9d23d4476bbe07cb380655b66e752be515551d831d3324d4b7881c1a7b91455af2616ea4e760c6bc13d72d3e10a83ef3b7b53b8216ecc18019422bb168ee355e7ca6fd521165b187c470dd6511c4e0e6b0e2de5ddf7c205fc182825dc92aa7687e11eded413a22042f05329d6ce1c6fc5f460d06268c47a5674e8fc878e1304bea88547a7727150a9810ed9ebebf6402683aece79e336d936d2eedff9eb9adcb9361ee80436168cc91424e4b763fc5f158f0361cf88b5c9391b84ff13078c44c7de08c04c4a0456fd79ec7076099106aed433c21771cb7d25959a69a827b154bdb18b9fdb49b5b29c321816414d653420b54a3a22b8c1264ae46e9d0cb86a69457ee2eb91cb1d737faeefa87e5e117ba72c184d9b6bd0f7ad50d64e501598df58fd2443de58093884976189de8ea5411483ac9c6b2afcb15807a4e6e95972ec43e277dd7030929205e82898a3e6ac7f6a4307f46aba70dceb088296cb565bba02d84b1f0ac939a39345f81401ab3fb3f3edfc276acdc602fb11ab382457867af118520b1390527eb5dfda8f239ed2cd203686a55c76310f59ccdc7337dfba891c976b185b801663f256bacff907f73bf57c2a4a2eb6a96dabe9ba591d4b1f1af7d9a1d8e2e31e9c1a3a934bb77209938d9cd4ce73e51fd59493cba283ef4a37aaee06b37e9ab21ea671cdb9f8fc41513a9fff8b500294b6921cb32f598a487a1edac4ff9fc178f6f34cf44be3f40df0598c5ebaa746d777a4072a199d5aad222c957bdab6450477c4f2f812eb8dde9efcbb2a3c9253b336ddfb38569194012eea735450b32ce331befaed5e0eb9913e48d39eb97284cc5a8127a20a93678994b4ccf32d13e0f8b893a889101342f2c3dad03620f5bbc43430a3b9a4be7278554131c99fbce4f6d69bf6f1ab242c69e007132ad717d1e7481dec5b89fecbf3df792df432a47dc1a1ee822bdbc3ba35a9ebcd9ec7ae028f195e6cd061a1e8e5b9fe95456a4c5371d8292a14b095fa3e13a8f2de5d884e267f345e2bc7275288dde758695ca7a7f46926cbbd9b7581c17a64f15c88d2099daf8e04cfb74040cd2c5d0afb872d997290d0ccce9f19886342671223fec208e1a28afc2f644ed7825852ae5e79e7a962e2eabd594b4be51828af3a31d3351d48049bfe926bc277106326b3a3b2aeb2b42b99378f5195c1129126acac0c09a0bed9a1621ade7c9d7b39710f7f6d52a6b105dda3b5681946aaa9eddc541cd20537ae231f4c3e368f13a83d69d860afcfb213a12542bffb00075e85c8924e618b265c40d426c62682ff56fe95284bed27be8dbae168fda4fcde0a5579d9ce5bbc93ac56cc17e652ae0d6f109fde4c63aa59a50bd69b03b647558b6b52014bfa7501b72394949b48861ca82bc71f1a37f7379c458b222702f77496031b5714209f777a801dab9e0aaf4d6be764994d2ba8aa840bcd3d18198308ee933276e3a298e62139cdf4700d28e8a278c1c72de089f9c7955582bff0b2a24ccb72085ad2169bb174b128bc2f79d502aa
CBC Decrypt:
 В рамках нашей работы мы определили следующую методологическую базу:
Сначала мы провели тщательный анализ существующих решений по дизайну интерфейса. Это включало изучение текущих тенденций, оценку пользовательского опыта и анализ преимуществ и недостатков различных подходов.
На основе результатов анализа мы разработали теоретическую модель. Эта модель включала ключевые элементы, которые, по нашему мнению, могут улучшить дизайн интерфейса и повысить его эффективность. Мы также рассматриваем принципы удобства использования и эргономики.
С помощью разработанной модели мы приступили к экспериментальному проектированию. Был создан прототип интерфейса, который включал в себя все ключевые элементы и инновации, предложенные в нашей теоретической модели.
Заключительным этапом было тестирование созданного прототипа. Мы провели серию тестов с участием конечных пользователей, чтобы оценить его эффективность и удобство. Результаты тестирования позволили нам сделать выводы о жизнеспособности нашей модели и предложить рекомендации по дальнейшему улучшению дизайна интерфейса.

PCBC Encrypt:
 0d03d15fe59e7b4752bbfff82e91d05216ab0d967053b9b5166e6321b9be3ce143118fc8717b708399d5b132db5461e47c8f13232c023084aac3cc3d87a52dfa6c38cad3a9a08bfeb061359b69cdef1871e18ed90d530db146ece51cc188ea7ea92550c3478c569f44a47091d8bbe3f79c828b137fdc000bc2d294d7c42e2e242b8d04ee5bca70530ee484b95eee1ddb8f37a6dac582abdf10f4d38842ff20b930876c2c773318e67f65e25f92c3ec65aa703f9ec31c16e283dcbbf3d939977073086d5fa73602adce3f2e9da4fa5e710b8610545d6597d1aef8ba2226126dabb04f0294e1ff9e56e5cec1a03400cc8c02a07dcd461548069ebc416658148d24def46433d08b5999d2dd1ade68f7c1b75972e0284c8d33125c3a110c4169bb12788d773b3239bb52df180377d893e9da211357d13b437bd76f1f8909483efcaf4e32089a1200f90711faf635a0f3652298bd6fcaca49bfad0e09b2ff38ec53064d15b1572f1362322ecaf4801256be9600ee6e164deb992d43bff2bc17ae1039f78de392752cbb5f68850e9176dd996b2be551fe06361b19850481869f99010956b44f095bf152c28a4db7e6f81026c3a2113aec1e550dcc5b4850fe79cd0448aad4c918f00c296ef7f7f6883533a9d27a9aaa95d115f083ef306a703ec4e9e6c5c57fbc0f268acb5daea888f8f1af761c5807788db2b4bc4875bc6c1749460eb39f0e67e27affd23c98e497a5633f4375fff7a4a8ceba033b5f732f6782156ed08bc2b79147a6df8e9c52b506efd148d2c852fa9d7339f4d5ed6a98161fb4cac7b2a269b6fc495e176f228a9bd73740a47205421d19e105937ff21fb8d3e257f317baf415864e42e587710cb4823349a2649c37a97b19a820579ca80c49bd029876ebaec615a1b8f4da0d3742d6c1ffe51e268cb696ed60c1a4c8cd11183ee28b6438a242383f7711073e487755746533d66a178f5e4f81b7e2f1b98307e24b495e8b9d3323a67c51676c396111b8e6589ecf11db696e80cf6fef17363381d6af9502b9f4bb5899326236001441ca10862bd535e5ec5240ac5b53a00e0ab69afee6459d8e134da4e1d1cff94d04f9e7eae3c8c4a1b54cd296c50b90560889ce4cfe1879e303a9fd15f4c96f4a9807265d713e6f7a1dd76fea08cac01fe3ce18c483f329353f7dec1c4e2e20fa08ba435f1089ceb68482f8b817d9a840d634b8951ab55453069935acd93aa4e2ebe3197852753040bca51a4a3b9ce79de21f356d39bb23d8e62506d1b660aff7512b960dbe6127656af19cf11fbaa4cd7f8cf1a42f2ab8a4cb99ba20f16b074453233cfc4022f87898b91c76a211d4e05f64088f03ad071886891d715dbff89dfe9c4d4d61cdbad57e126fc3276f66ea0488bea01dbbdf5d42651db72978c145d02092fa8d20db75002575ff6c1e6d1a39c6bf8b7a05327a9e2acd265e2d2e310255df4c357ac42abe6fdd1e402325348ac1a268c3d7a899f1ffeb24a6c44c0b17d3171895db161b7db33eec6662b7c79e8021a7d70fd150d1a4394197d472b0429fc06655c93cde95a89b57c70ac220fa31b0cac51a40606eb3694c8f619f5e3210fc6f3792899bc11bf4577b3bf93c4c905dd6085ab5bd14ec22502441c558e745d87977b71631957b3641c8a1cb58c5f4c3535e34b34a9bb2e09a50cc42f48e9b3220b5e50ffbd76ec1f1e30ac5bc44d7f21ac7900af68ad18f05364572d61e3a15728aaeebaf50bebd53a93046af6e19db1698eb4dc58027d8f8db9ec7b2929c9a5cd53d6de974bcb670f9fc81633afb3697f285d4c320d516b00b4c133962a58f7eac3c7b82a17aa12b402e390e9796b54ff421775cb9ea32ecd1cadd8c55e63627636642a42b47adb658a66ac7a7922e8f158496b2a46f01a27a88244215dec082d45e22e4792a896b4e86959384b86d0c7ff69f0e06e2e677921b1bc44f2c946299da0b875848b2139eb0be22056bf759cc9edf7b33c0bbda3606cf96591f8cb28378ebb177fe8b94ddab006c1a298da67c1c8deb8b78d0f4c3d9010598d81d3fdb709a92d7c1fcb0c077231c617c947fc5ebdaff11abda4adda4d801e547c75dcb742b29962560f24f0af5fc30017d125e06825869fd58d6efa5462b29985175d3063be8805439474ee69e597fcc71b0079b3758f9fceb623efa1d86e3605af0f7032fec0759b28cb89f3dcc8114dbb18a6b932eee8a65d4a8b8245615744d1b013cdc980c1d270a50848e868ff47e8ad0df027e198d46cb3fd0b7309847de62a5e399dcec1e1bfb73844e516b2b65b7732b29ce3d07451697613fac4e0a8a7788c0b466cfcabce92e353e4878dfc5364a1ab5af2baf5f81deda2d217d2b781c78f5f4b876ef8041ae5dc51f553731d475e845f62f92152dbaae2c1b894905c2582c55f6c1d9302234542e424ece42259491d21f0aa59e12db68cd7f70b0b759931ffe0f326c55f04db1447aa8a5643563fac11d6942584b959b7ce4b9fa745fb9108849bf6cfb62ce731c6091de6d09233d7dedb348be9b73274a4019fc66e0218b821cab922fb517848fa2199c39aedbb3f402a6bc83086fad8978f5fe33af5931d9e4613e10916e0ac1db7397d940f55163cb69fff0a9e3041fa349e7339feedf162782a0476b2e421f7a3837cf90e74e9ecec4444cfec24089f612145a7440fd987590aa53d5f902e49b4ab9cd22043e464f714a78e50aa20fd9fe0cc8547f2088866862e0dd5d86f6e590cd80755c1791b87409d2d8dbe164f3bc565217dc3dff40c13e528e64afe67dac64313bfea6ee0cf52188e051b1e08b3410f09ac345124a8e01d13e46ae71969abc49
PCBC Decrypt:
 В рамках нашей работы мы определили следующую методологическую базу:
Сначала мы провели тщательный анализ существующих решений по дизайну интерфейса. Это включало изучение текущих тенденций, оценку пользовательского опыта и анализ преимуществ и недостатков различных подходов.
На основе результатов анализа мы разработали теоретическую модель. Эта модель включала ключевые элементы, которые, по нашему мнению, могут улучшить дизайн интерфейса и повысить его эффективность. Мы также рассматриваем принципы удобства использования и эргономики.
С помощью разработанной модели мы приступили к экспериментальному проектированию. Был создан прототип интерфейса, который включал в себя все ключевые элементы и инновации, предложенные в нашей теоретической модели.
Заключительным этапом было тестирование созданного прототипа. Мы провели серию тестов с участием конечных пользователей, чтобы оценить его эффективность и удобство. Результаты тестирования позволили нам сделать выводы о жизнеспособности нашей модели и предложить рекомендации по дальнейшему улучшению дизайна интерфейса.

Process finished with exit code 0
```

## Вывод

В ходу лабораторной работы, я выучил несколько подходы для щифрования и дешифрования текст в файле.
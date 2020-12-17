### macOS 에서 Jupyter Notebook 설치하기

1. macOS에는 기본적으로 Python이 설치되어 있다.

```bash
$ python -V
$ python3 -V
```

> 파이썬 버전 확인하기

2. pip를 업그레이드 한다.

```bash
$ pip3 install --upgrade pip
```

3. 주피터 노트북을 설치한다.

```bash
$ pip3 install jupyter
```

4. 주피터 노트북을 실행한다.

```bash
$ jupyter notebook
```

> 이때, "command not found jupyter"라는 에러가 발생하는 경우가 있다. 
>
> macOS에서 python3를 설치할 때 공식 홈페이지에서 pkg 파일을 받아 설치한 경우 이러한 에러가 발생할 수 있다고 한다.  
>
> 따라서 이 경우에는 python3를 삭제 후 brew 명령어를 통해 다시 설치해 주면 된다.

```bash
$ brew install python3
```


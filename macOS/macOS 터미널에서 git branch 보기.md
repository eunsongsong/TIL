### macOS 터미널에서 git branch 보기

1. 홈 디렉토리의 .zshrc 파일에서 vi 편집기를 실행한다.

```bash
vi ~/.zshrc
```

2. .zshrc 파일에 아래 내용을 입력한다.

```bash
# Git branch in prompt.
parse_git_branch() {
    git branch 2> /dev/null | sed -e '/^[^*]/d' -e 's/* \(.*\)/ (\1)/'
}
export PS1="\u@\h \W\[\033[32m\]\$(parse_git_branch)\[\033[00m\] $ "
```

3. source 명령어로 .zshrc 파일 내용을 적용한다.
```bash
source ~/.zshrc
```

1.配置

hp@tfl-lalala MINGW64 /d/git-tfl
$ git config --global user.name "xiaoliang"

hp@tfl-lalala MINGW64 /d/git-tfl
$ git config --global user.email 651147191@qq.com

2.克隆项目

 git clone https://github.com/Stone-WYD/TMSP.git

3.初始化为git仓库

git init 

4.状态转变

<img src="C:\Users\hp\AppData\Roaming\Typora\typora-user-images\image-20230915104230218.png" alt="image-20230915104230218" style="zoom: 50%;" />

5.带简介的提交与撤销提交

git commit -m '第一次提交'

git reset  HEAD 文件名

git reset head ~ --soft

6.查看文件状态

git status   红色文件为未暂存  绿色文件为已暂存  还会显示当前分支

git diff 查看文件修改

git log 查看文件提交记录

git remote add  xxx  https://github.com/cxlllll/algorithm.git 本地git添加名为xxx的远程仓库

git remote 查看git中远程仓库名

git remote rename xiaoliang argorithm 修改远程仓库名字  

7.分支操作

git branch --list 查看分支 带*就是当前分支

git branch 分支名 创建分支

git check out  [可选 -b 新建分支并切换到这个分支] '分支名' 切换分支

 git log --all --graph  图形化展示提交记录

git merge 分支名  合并当前分支名分支至当前分支

git push 远程分支名 分支名 将当前分支推送到远程项目中

git fetch 拉去远程分支

git checkout -b develop xiaolang/develop 在 Git 中创建一个名为 `develop` 的新分支，并以远程分支 `xiaolang/develop` 的内容作为新分支的起点。

 8.要是在develop_1开发着代码test.txt，然后这段代码还没有测试，不能提交，但是其他分支遇到bug，你需要切换分支，切换分支会报错，因为修改的地方没有提交，此时，使用git stash 储藏而不提交我们修改的东西，此时切换其他分支成功，在其他分支操作完毕以后，使用git stash apply来恢复我们储藏的内容。

可以使用 git stash 来存储多次 使用git stash list来看我们所存储的东西 ，然后使用 git stash  apply stash@{n}来恢复到某个版本的内容。

9.本地新建项目并与远程git仓库连接

​	1.github新建仓库

​	2.本地新建项目

​	3.执行一下命令![image-20230918095852062](C:\Users\hp\AppData\Roaming\Typora\typora-user-images\image-20230918095852062.png)














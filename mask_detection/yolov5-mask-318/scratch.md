###使用
1.使用GPU训练数据集，终端输入：python train.py --data mask_data.yaml --cfg mask_yolov5s.yaml --weights pretrained/yolov5s.pt --epoch 100 --batch-size 4 --device '0' 

2.验证：python val.py --data data/mask_data.yaml --weights runs/train/exp_self/weights/best.pt --img 640

3.使用：运行window.py文件
###遇到的问题
1.使用CPU训练速度过慢

2.pytorch和cuda下载的版本不对，在cmd中测试torch.cuda.is_available()返回False

3.使用GPU进行验证操作中，报错显示GPU显存不足，换成使用CPU进行验证
###运行结果
![avatar](D:/Exercise_items/mask_detection/yolov5-mask-318/val_result.png)
400张图片 
<br/>总精度为0.789 
<br/>检测口罩的精度为0.616 
<br/>检测人脸的精度为0.962
<br/>推理一张图片的时间为1.3ms
<br/>预处理时间：178ms
<br/>侯处理时间：0.7ms
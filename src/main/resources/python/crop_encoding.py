import cv2
import sys
import numpy as np
import face_recognition as fr
#crop
image = cv2.imread("D://idea_folder//schoolvideos//pic//pic//"+sys.argv[1]+".png")
crop_image = image
#[34:141,107:214]
cv2.imwrite("D://idea_folder//schoolvideos//pic//pic//"+sys.argv[1]+".png",crop_image)
#encoding
face_image=fr.load_image_file("D://idea_folder//schoolvideos//pic//pic//"+sys.argv[1]+".png")
print(fr.face_encodings(face_image))
encoding=fr.face_encodings(face_image)[0]
#verify...

#save
np.save("D://idea_folder//schoolvideos//pic//picData//"+sys.argv[1]+".npy",encoding)


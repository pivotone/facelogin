import os
import face_recognition
import sys
import cv2
import numpy as np

def facerec(temp_img_name):
	image = cv2.imread("D://idea_folder//schoolvideos//pic//pic//"+temp_img_name)
	crop_image = image
	#[34:141,107:214]
	cv2.imwrite("D://idea_folder//schoolvideos//pic//pic//"+temp_img_name,crop_image)
	
	image = face_recognition.load_image_file("D://idea_folder//schoolvideos//pic//pic//"+temp_img_name)
	
	known_faces=[]
	filenames=[]

	for filename in os.listdir("D://idea_folder//schoolvideos//pic//picData"):
		filenames.append(filename)
		encoding=np.load("D://idea_folder//schoolvideos//pic//picData//"+filename)
		known_faces.append(encoding)
	
	face_encoding = face_recognition.face_encodings(image)[0]
	
	tolerance=0.4
	face_distance_list = face_recognition.custom_compare_faces(known_faces, face_encoding)
	#face_distance_list = face_recognition.compare_faces(known_faces, face_encoding)
	#print (face_distance_list)

	most_like_face=min(face_distance_list)
	if(most_like_face>tolerance):
		print(-1)
		return
	else:
		i=face_distance_list.index(min(face_distance_list))
		print (filenames[i][:-4])
	return
facerec(sys.argv[1])
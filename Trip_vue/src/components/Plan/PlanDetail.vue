<script setup>
import { ref, reactive, onMounted } from "vue";
import { usePlanStore } from "@/stores/planStore";
const props = defineProps({ t: Object });

const planStore = usePlanStore();
const { addPlanItem } = planStore;

const date = ref("");
const cost = ref(0);
const memo = ref("");
const emit = defineEmits(["closeModal"]);
function closeModal() {
  emit("closeModal");
}

const inputInsertItem = () => {
  addPlanItem([date.value, cost.value, memo.value, props.t]);
  closeModal();
};

const openBrowser = () => {
  window.open("https://search.naver.com/search.naver?query=" + props.t.title);
};
</script>

<template>
  <div>
    <div class="black-bg">
      <div class="white-bg">
        <div id="img-box">
          <img v-if="t.firstImage" :src="t.firstImage" alt="사진" />
          <img v-else src="@/assets/logo0.svg" alt="사진" />
          <button>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="30"
              height="30"
              fill="currentColor"
              class="bi bi-heart"
              viewBox="0 0 16 16"
            >
              <path
                d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15"
              />
            </svg>
          </button>
        </div>
        <div class="text-box">
          <h4>{{ t.title }}</h4>
          <div class="addr-saerch">
            <p>{{ t.addr1 }}</p>
            <!-- <input type="button" value="네이버 검색" @click="openBrowser" /> -->
            <!-- 네이버 url 검색 + 이모티콘으로 교체 -->

            <button class="search" @click="openBrowser">
              네이버
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-search"
                viewBox="0 0 16 16"
              >
                <path
                  d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"
                />
              </svg>
            </button>
          </div>
        </div>
        <div class="input-data">
          <div class="form-box">
            <div class="date-cost">
              <div>
                <label for="date">날짜</label>
                <input id="date" type="datetime-local" v-model="date" />
              </div>

              <div id="cost-box">
                <label for="cost">금액 </label>
                <input id="cost" type="number" v-model="cost" /><span>원</span>
              </div>
            </div>
            <label for="memo">메모</label>
            <textarea placeholder="메모 작성하기.." v-model="memo"></textarea>
            <!-- <input id="memo" type="textarea" /> -->
          </div>
        </div>
        <div class="modal-btn">
          <button @click="inputInsertItem()">일정 추가</button>
          <button @click="closeModal()">닫기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
button {
  background-color: var(--main-color);
  color: white;
  font-weight: bold;
  border-radius: 3px;
  border: none;
  margin: 5px;
  padding: 5px;
}

.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  left: 0;
  top: 0;
  z-index: 6;
  display: flex;
  justify-content: center;
  align-items: center;

  .white-bg {
    max-width: 800px;
    max-height: 800px;

    display: flex;
    flex-direction: column;

    padding: 20px;
    border-radius: 8px;
    background: white;
    z-index: 10;
    color: black;

    #img-box {
      max-width: 800px;
      max-height: 400px;
      overflow-y: auto;
      border-radius: 10px;
      position: relative;

      button {
        position: absolute;
        top: 10px;
        right: 10px;
        height: 40px;
        background-color: transparent;
      }

      img {
        width: 100%;
        height: 100%;
      }
    }

    .text-box {
      display: flex;
      flex-direction: column;
      margin: 10px;

      h4 {
        font-weight: bold;
        color: var(--main-color);
      }

      input {
        border: none;
        background-color: transparent;
      }

      .addr-saerch {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
      }
    }

    .input-data {
      .form-box {
        display: flex;
        flex-direction: column;
        margin: 10px;

        label {
          font-weight: bold;
          margin: 5px;
        }

        input {
          margin: 5px;
          border: 1px solid var(--main-color);
          border-radius: 3px;
          padding: 5px;
        }

        .date-cost {
          display: flex;
          flex-direction: row;
          justify-content: space-between;
        }

        textarea {
          max-width: 100%;
          height: 120px;
          margin: 5px;
          border: 1px solid var(--main-color);
          border-radius: 3px;
          padding: 5px;
          resize: none;
        }
      }
    }

    .modal-btn {
      display: flex;
      justify-content: end;
      margin: 10px;
    }
  }
}
::-webkit-scrollbar {
  width: 10px;
}

::-webkit-scrollbar-thumb {
  background-color: var(--main-color);
  border-radius: 10px;
}
</style>

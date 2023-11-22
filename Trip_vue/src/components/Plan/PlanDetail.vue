<script setup>
import { ref } from "vue";
import { useTripStore } from "@/stores/tripStore";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
defineProps({ t: Object });

const tripStore = useTripStore();
const planStore = usePlanStore();
const { addPlanItem } = tripStore;

const date = ref("");
const cost = ref(0);
const memo = ref("");
const emit = defineEmits(["closeModal"]);
function closeModal() {
  //store의 useModal false로 변경
  emit("closeModal");
}

const inputInsertItem = () => {
  addPlanItem([date.value, cost.value, memo.value]);
  closeModal();
};
</script>

<template>
  <div>
    <div class="black-bg">
      <div class="white-bg">
        <div id="img-box">
          <img v-if="t.firstImage" :src="t.firstImage" alt="사진" />
          <img v-else src="@/assets/logo0.svg" alt="사진" />
        </div>
        <div class="text-box">
          <h4>{{ t.title }}</h4>
          <div class="addr-saerch">
            <p>{{ t.addr1 }}</p>
            <input type="button" value="네이버 검색" />
            <!-- 네이버 url 검색 + 이모티콘으로 교체 -->
          </div>
        </div>
        <div class="input-data">
          <form>
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
          </form>
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
      form {
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

      button {
        background-color: var(--main-color);
        color: white;
        font-weight: bold;
        border-radius: 3px;
        border: none;
        margin: 5px;
        padding: 5px;
      }
    }
  }
}
</style>
